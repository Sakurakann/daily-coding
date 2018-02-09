package org.sknn.base.domain;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package:
 * org.sknn.base.domain. User: Administrator. Date: 2018-02-05 09:56. Author:
 * Haiyangp.
 */
public class User {

  /**
   * 用户编号
   */
  private Integer uid;
  /**
   * 用户名
   */
  private String username;
  /**
   * 密码
   */
  private String password;
  /**
   * 邮箱
   */
  private String email;
  /**
   * 密码盐
   */
  private String salt;
  /**
   * 备注
   */
  private String remark;

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  @Override
  public String toString() {
    return "User{" +
        "uid=" + uid +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", email='" + email + '\'' +
        ", salt='" + salt + '\'' +
        ", remark='" + remark + '\'' +
        '}';
  }

  /**
   * uid一致,视为同一对象
   * @param o 对比对象
   * @return 是否为同一元素
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    User user = (User) o;

    return uid != null ? uid.equals(user.uid) : user.uid == null;
  }

  @Override
  public int hashCode() {
    return uid != null ? uid.hashCode() : 0;
  }
}
