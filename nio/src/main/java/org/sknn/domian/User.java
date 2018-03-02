package org.sknn.domian;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package: org.sknn.domian.
 * User: Administrator. Date: 2018-03-01 16:42. Author: Haiyangp.
 */
public class User {
  private int age;
  private String name;

  public User() {
  }

  public User(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
