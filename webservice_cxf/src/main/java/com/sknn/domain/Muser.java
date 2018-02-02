package com.sknn.domain;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package: com.sknn.domain. User: Administrator.
 * Date: 2018-01-19 15:49. Author: Haiyangp.
 */
public class Muser {

  /**
   * 开通挂机的号码区号
   * @NotNull
   */
  private String areaCode;
  /**
   * 开通挂机的号码
   * @NotNull
   */
  private String phone;
  /**
   * 业务类型
   * 0: 开户
   * 1: 销户
   * @NotNull
   */
  private int type;
  /**
   * 企业\用户的详细地址
   */
  private String address;
  /**
   * 企业\用户名称,若无则默认为phone
   */
  private String userName;
  /**
   * 用户套餐短信条数(type = 0, notNull)
   */
  private String defCut;

  /**
   * 业务办理返回码
   * 1: 成功
   * 0: 失败
   */
  private int returnCode;
  /**
   * 业务办理返回信息
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

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getDefCut() {
    return defCut;
  }

  public void setDefCut(String defCut) {
    this.defCut = defCut;
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
