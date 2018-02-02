package com.sknn.domain;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package: com.sknn.domain.
 * User: Administrator. Date: 2018-01-23 16:30. Author: Haiyangp.
 */
public class BaseReturn {

  /**
   * 需要设置短信信息的号码区号
   */
  private String areaCode;
  /**
   * 需要设置短信信息的号码
   */
  private String phone;
  /**
   * 设置结果 1: 成功; 0: 失败;
   */
  private int returnCode;
  /**
   * 结果原因(非必须)
   */
  private String returnMessage;

  public String getAreaCode() {
    return areaCode;
  }

  public void setAreaCode(String areaCode) {
    this.areaCode = areaCode;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public int getReturnCode() {
    return returnCode;
  }

  public void setReturnCode(int returnCode) {
    this.returnCode = returnCode;
  }

  public String getReturnMessage() {
    return returnMessage;
  }

  public void setReturnMessage(String returnMessage) {
    this.returnMessage = returnMessage;
  }
}
