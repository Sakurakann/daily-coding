package org.sknn.configfile.json;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import org.sknn.domain.Author;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package:
 * org.sknn.configfile.json. User: Administrator. Date: 2018-02-08 11:13.
 * Author: Haiyangp.
 */
public class JsonAnalyserTest {

  @Test
  public void testJsonAnalyser() {

    try {
      Author author = JsonAnalyser.jsonAnalyser(Author.class);
      Assert.assertNotNull(author);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
