package org.sknn.configfile.property;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package:
 * org.sknn.configfile.property. User: Administrator. Date: 2018-02-08 08:49.
 * Author: Haiyangp.
 */
public class PropertiesAnalyser {
  private static String DB_FILE_PATH = "/db.properties";

  private static Properties DB_PROPERTY = new Properties();

  static {
    try {
      InputStream resource = PropertiesAnalyser.class
          .getResourceAsStream(DB_FILE_PATH);

      /*try {
        Class.forName("org.sknn.configfile.property.PropertiesAnalyser")
            .getResourceAsStream("db.properties");
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
      // 还可以通过classLoader来加载资源文件 通过this.getClassLoader,
      // 但是static中不能使用this关键字;*/

      DB_PROPERTY.load(resource);
      resource.close();
    } catch (FileNotFoundException e) {
      // TODO  log
      System.out.println("文件[ " + DB_FILE_PATH +" ]不存在!");
      e.printStackTrace();
    } catch (IOException e) {
      // TODO  log
      System.out.println("DBProperty加载失败!");
      e.printStackTrace();
    }
  }

  public static String getDBPropertyByName(String propName) {
    return DB_PROPERTY.getProperty(propName, "");
  }

  public static boolean restoreDBProperty(String propName, String propValue)
      throws FileNotFoundException {
    return restoreDBProperty(propName, propValue, "");
  }

  public static boolean restoreDBProperty(String propName, String propValue, String comments)
      throws FileNotFoundException {
    DB_PROPERTY.setProperty(propName, propValue);
    FileOutputStream propOutStream = new FileOutputStream(
        DB_FILE_PATH);
    try {
      DB_PROPERTY.store(propOutStream, comments);
      propOutStream.flush();
      propOutStream.close();
      return true;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }
}
