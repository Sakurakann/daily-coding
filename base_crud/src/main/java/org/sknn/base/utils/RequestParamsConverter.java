package org.sknn.base.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package:
 * org.sknn.base.utils. User: Administrator. Date: 2018-02-08 16:14. Author:
 * Haiyangp.
 */
public class RequestParamsConverter {

  public static <T> T paramsMap2Pojo(Map<?, ?> paramsMap, Class<T> clazz) {
    try {
      T t = clazz.newInstance();
      // register converter
      ConvertUtils.register(new DateConverter(), clazz);
      BeanUtils.populate(t, paramsMap);
      return t;
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    return null;
  }
}
