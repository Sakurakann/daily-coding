package com.sknn.test;

import static org.junit.Assert.assertNotNull;

import com.alibaba.fastjson.JSON;
import com.sknn.domain.Muser;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package: com.sknn.test. User: Administrator.
 * Date: 2018-01-19 15:43. Author: Haiyangp.
 */
public class JsonTest {

  @Test
  public void testBean2JsonString() {
    Muser muser = new Muser();

    muser.setAddress("杭州");
    muser.setAreaCode("0571");
    muser.setDefCut("100");
    muser.setPhone("15988842888");
    muser.setReturnCode(1);
    muser.setType(0);
    muser.setReturnMessage("开通成功");
    muser.setUserName("sknn");

    String string = JSON.toJSONString(muser);
    assertNotNull(string);
  }

  @Test
  public void JsonString2Bean() {
    String str = "{"
        + "\"userName\":\"sakura\","
        + "\"phone\":\"15645643216\","
        + "\"type\":\"0\","
        + "\"areaCode\":\"0571\","
        + "\"address\":\"杭州\","
        + "\"defCut\":\"100\","
        + "\"returnCode\":\"1\","
        + "\"returnMessage\":\"成功\""
        + "}";

    //System.out.println(str + "  原字符串");

    Muser muser = JSON.parseObject(str, Muser.class);
    assert muser != null;
  }

}
