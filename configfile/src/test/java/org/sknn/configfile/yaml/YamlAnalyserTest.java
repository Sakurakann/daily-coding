package org.sknn.configfile.yaml;

import org.junit.Assert;
import org.junit.Test;
import org.sknn.domain.Author;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package:
 * org.sknn.configfile.yaml. User: Administrator. Date: 2018-02-08 13:36.
 * Author: Haiyangp.
 */
public class YamlAnalyserTest {

  @Test
  public void testYamlAnalyser() {
    Author author = YamlAnalyser.yamlAnalyser(Author.class);
    Assert.assertNotNull(author);
  }

}
