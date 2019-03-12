package com.infinova.sso.service_test;

import com.infinova.sso.entity.User;
import com.infinova.sso.service.RedisService;
import com.infinova.sso.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 类功能简述： 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/8 14:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {

	private Logger logger = LoggerFactory.getLogger(RedisService.class);

	@Autowired
	private RedisService redisService;
	@Autowired
	private RedisUtil redisUtil;

	@Test
	public void getTimeTest() throws Exception {
		logger.info("时间为：{}", redisService.getTime());
		Thread.sleep(1000);
		logger.info("时间为：{}", redisService.getTime());
		Thread.sleep(1000);
		logger.info("时间为：{}", redisService.getTime());
		redisService.deleteTime();
		Thread.sleep(1000);
		logger.info("时间为：{}", redisService.getTime());
	}

	@Test
	public void getTimeIdTest() throws Exception {
		logger.info("缓存时间：{}", redisService.updateTime("1"));
		Thread.sleep(1000);
		logger.info("1s后取数据：{}", redisService.getTime("1"));
		Thread.sleep(1000);
		logger.info("1s后更新时间：{}", redisService.updateTime("1"));
		Thread.sleep(1000);
		logger.info("1s后取数据：{}", redisService.getTime("1"));
		RedisUtil.set("test1", "test1", 100000);
	}

	@Test
	public void testCaching() throws Exception {
		User user = new User("aaa","bbb");
		redisService.testCaching(user);
	}
}
