package com.example.dxfl.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Description
 *
 * @author fxb
 * @date 2018-08-31
 */
@Aspect
@Component
public class ReadOnlyInterceptor implements Ordered {
    private static final Logger log= LoggerFactory.getLogger(ReadOnlyInterceptor.class);

    @Around("@annotation(readOnly)")
    public Object setRead(ProceedingJoinPoint joinPoint,ReadOnly readOnly) throws Throwable{
        try{
            DbContextHolder.setDbType(DbContextHolder.READ);
            return joinPoint.proceed();
        }finally {
            DbContextHolder.clearDbType();
            log.info("清除threadLocal");
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
