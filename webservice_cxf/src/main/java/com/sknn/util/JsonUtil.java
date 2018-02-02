package com.sknn.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package: com.sknn.util. User: Administrator.
 * Date: 2018-01-19 16:49. Author: Haiyangp.
 */
public class JsonUtil<T> {

  /**
   * 将对象压制成json形式字符串
   * @param obj 需要转化的对象
   * @return 对象的json字符串格式
   */
  public static String bean2JsonString(Object obj) {
    if (obj == null) {
      return null;
    }
    return JSON.toJSONString(obj);
  }

  /**
   * 将map转化为json格式数据
   * @param map 需要转化的map对象
   * @return map对象的json字符串形式
   */
  public static String map2JsonString(Map<? extends String, ? extends Object> map) {
    if (null == map || map.size() <= 0) {
      return null;
    }
    JSONObject jsonObject = new JSONObject();
    Set<? extends Entry<? extends String, ?>> mapEntrySet = map.entrySet();
    for (Entry<?, ?> entry : mapEntrySet) {
      String key = (String)entry.getKey();
      Object value = entry.getValue();
      jsonObject.put(key, value);
    }
    return jsonObject.toJSONString();
  }


  /**
   * 将json字符串解析为Object对象
   * @param jsonString json字符串
   * @return 对象
   */
  public static Object jsonString2Bean(String jsonString) {
    return jsonString2Bean(jsonString, Object.class);
  }

  /**
   * 将json字符串解析为指定类型对象
   * @param jsonString json字符串
   * @param clazz 指定类型的类
   * @param <T> 指定类型
   * @return 指定类型对象
   */
  public static <T> T jsonString2Bean(String jsonString, Class<T> clazz) {
    if (jsonString.length() <= 0 || "".equals(jsonString.trim())){
      return null;
    }
    return JSON.parseObject(jsonString, clazz);
  }
}
