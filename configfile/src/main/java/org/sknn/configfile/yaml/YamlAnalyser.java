package org.sknn.configfile.yaml;

import java.io.IOException;
import java.io.InputStream;
import org.yaml.snakeyaml.Yaml;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package:
 * org.sknn.configfile.yaml. User: Administrator. Date: 2018-02-08 13:26.
 * Author: Haiyangp.
 */
public class YamlAnalyser {
  private static final String YAML_FILE_PATH = "/author.yml";

  public static <T> T yamlAnalyser(Class<T> t) {

    Yaml yaml = new Yaml();
    InputStream yamlInStream = YamlAnalyser.class
        .getResourceAsStream(YAML_FILE_PATH);
    T as = yaml.loadAs(yamlInStream, t);
    try {
      yamlInStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return as;

  }

}
