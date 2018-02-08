package org.sknn.configfile.property;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package:
 * org.sknn.configfile.property. User: Administrator. Date: 2018-02-08 09:10.
 * Author: Haiyangp.
 */
public class PropertyTest {

  @Test
  public void testGetDBPropertyByName() {
    String username = PropertiesAnalyser.getDBPropertyByName("username");
    Assert.assertEquals(username, "sknn");
  }

  @Test
  public void testRestoreDBProperty() {
    try {
      boolean b = PropertiesAnalyser
          .restoreDBProperty("password", "sakura", "修改密码");
      Assert.assertTrue(b);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
