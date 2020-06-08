package com.fanxb.redismq.configuration;

import com.fanxb.redismq.annotation.MqConsumer;
import com.fanxb.redismq.entity.RedisConsumer;
import com.fanxb.redismq.util.RedisMqUtil;
import io.lettuce.core.RedisConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA
 * Created By Fxb
 * Date: 2020/3/24
 * Time: 15:37
 *
 * @author fanxb
 */
@Component
public class MqConfiguration implements ApplicationRunner {
    Logger log = LoggerFactory.getLogger(MqConfiguration.class);
    @Autowired
    private RedisMqUtil mqUtil;

    /**
     * 订阅对象与执行方法关系
     */
    private static final Map<String, RedisConsumer> topicMap = new HashMap<>();
    /**
     * 执行线程池
     */
    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 10, 10000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1000));

    @Autowired
    ApplicationContext context;

    @Override
    public void run(ApplicationArguments args) {
        Map<String, Object> map = context.getBeansWithAnnotation(MqConsumer.class);
        map.values().forEach(item -> {
            if (!(item instanceof RedisConsumer)) {
                log.warn("注意检测到被@EsConsumer注解的类{}未实现RedisConsumer接口", item.getClass().getCanonicalName());
                return;
            }
            MqConsumer[] annotations = item.getClass().getAnnotationsByType(MqConsumer.class);
            MqConsumer annotation = annotations[0];
            String topic = annotation.topic();
            if (topicMap.containsKey(topic)) {
                log.error("多个消费者{},消费同一个消息:{},已忽略", item.getClass().getCanonicalName(), topic);
            } else {
                topicMap.put(topic, (RedisConsumer) item);
            }

        });
        log.info("redis订阅信息汇总完毕！！！！！！");
        //由一个线程始终循环获取es队列数据
        threadPoolExecutor.execute(loop());
    }

    private Runnable loop() {
        return () -> {
            while (true) {
                AtomicInteger count = new AtomicInteger(0);
                topicMap.forEach((k, v) -> {
                    try {
                        String message = mqUtil.getRedisTemplate().opsForList().rightPop(k);
                        if (message == null) {
                            count.getAndIncrement();
                        } else {
                            pushTask(v, message, k);
                        }
                    } catch (RedisConnectionFailureException connException) {
                        log.error("redis无法连接,10s后重试", connException);
                        sleep(10);
                    } catch (Exception e) {
                        log.error("redis消息队列异常", e);
                    }
                });
                if (count.get() == topicMap.keySet().size()) {
                    //当所有的队列都为空时休眠1s
                    sleep(1);
                }
            }
        };
    }

    /**
     * 功能描述: 推送任务到线程池中执行
     *
     * @param list  list
     * @param value value
     * @param key   key
     * @author 123
     * @date 2020/3/28 23:52
     */
    private void pushTask(RedisConsumer item, String value, String key) {
        threadPoolExecutor.execute(() -> {
            try {
                item.deal(value);
            } catch (Exception e) {
                log.error("执行消费任务出错", e);
                //非广播消息进行数据回补
                mqUtil.getRedisTemplate().opsForList().rightPush(key, value);
            }
        });
    }

    private void sleep(int s) {
        try {
            TimeUnit.SECONDS.sleep(s);
        } catch (Exception e) {
            log.error("休眠失败", e);
        }
    }
}

