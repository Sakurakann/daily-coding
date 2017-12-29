package com.sknn.daily.springaspectj.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created with IntelliJ IDEA.
 * Project: daily-coding.
 * Package: com.sknn.daily.springaspectj.aspects.
 * User: Administrator.
 * Date: 2017-12-29 15:51.
 * Author: Haiyangp.
 */
@Aspect //标识为切面
public class CommonLogAspect {
  /**
   * 获取log4j日志对象
   */
  private static final Logger LOGGER = Logger.getLogger(CommonLogAspect.class);

  /**
   * 定义切点,有注解CommonLog的地方
   */
  @Pointcut("@annotation(CommonLog)")
  public void commonLogPointcut() {
  }

  @Around("commonLogPointcut()")
  public Object doSurround(ProceedingJoinPoint proceedingJoinPoint) {
    Object[] args = proceedingJoinPoint.getArgs();
    return null;
  }

}
