package org.sknn.domain;

import java.util.List;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package: org.sknn.domain.
 * User: Administrator. Date: 2018-02-08 10:37. Author: Haiyangp.
 */
public class Author {
  private String name;
  private List<Integer> phone;
  private List<Tool> tools;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Integer> getPhone() {
    return phone;
  }

  public void setPhone(List<Integer> phone) {
    this.phone = phone;
  }

  public List<Tool> getTools() {
    return tools;
  }

  public void setTools(List<Tool> tools) {
    this.tools = tools;
  }


  @Override
  public String toString() {
    return "Author{" +
        "name='" + name + '\'' +
        ", phone='" + phone + '\'' +
        ", tools=" + tools +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Author author = (Author) o;

    if (name != null ? !name.equals(author.name) : author.name != null) {
      return false;
    }
    if (phone != null ? !phone.equals(author.phone) : author.phone != null) {
      return false;
    }
    return tools != null ? tools.equals(author.tools) : author.tools == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (phone != null ? phone.hashCode() : 0);
    result = 31 * result + (tools != null ? tools.hashCode() : 0);
    return result;
  }
}
