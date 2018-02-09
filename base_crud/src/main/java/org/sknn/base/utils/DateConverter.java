package org.sknn.base.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.commons.beanutils.Converter;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package:
 * org.sknn.base.utils. User: Administrator. Date: 2018-02-08 16:24. Author:
 * Haiyangp.
 */
public class DateConverter implements Converter {

  @Override
  public Object convert(Class aClass, Object o) {
    if (o == null) {
      return null;
    }
    if (!(o instanceof String)) {
      return o;
    }
    String value = (String) o;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try {
      return dateFormat.parse(value);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }
}
