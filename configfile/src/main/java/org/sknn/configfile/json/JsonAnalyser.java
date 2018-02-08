package org.sknn.configfile.json;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package:
 * org.sknn.configfile.json. User: Administrator. Date: 2018-02-08 10:42.
 * Author: Haiyangp.
 */
public class JsonAnalyser {

  private static final String JSON_FILE_PATH = "/author.json";

  public static <T> T jsonAnalyser(Class<T> t) throws IOException {

    // 获取输入流
    InputStream jsonInStream = JsonAnalyser.class.getResourceAsStream(JSON_FILE_PATH);
    // 将输入流转成字符
    String jsonString = IOUtils.toString(jsonInStream, "utf-8");
    Gson gson = new Gson();

    return gson.fromJson(jsonString, t);

  }
}
