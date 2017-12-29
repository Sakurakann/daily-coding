package com.sknn.daily.springaspectj.annotations;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * Project: daily-coding.
 * Package: com.sknn.daily.springaspectj.annotations.
 * User: Administrator.
 * Date: 2017-12-29 15:29.
 * Author: Haiyangp.
 * 通用Log注解
 */
@Documented() //可以文档化
@Retention(RetentionPolicy.RUNTIME) //保留时间长短(运行时有效)
@Target({ElementType.METHOD}) //标识改注解是用在方法上的
public @interface  CommonLog {

}
