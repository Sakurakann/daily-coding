package org.sknn.domain;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package: org.sknn.domain.
 * User: Administrator. Date: 2018-02-08 10:38. Author: Haiyangp.
 */
public class Tool {

  private String name;
  private String useAge;

  public String getUseAge() {
    return useAge;
  }

  public void setUseAge(String useAge) {
    this.useAge = useAge;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Tool tool = (Tool) o;

    if (name != null ? !name.equals(tool.name) : tool.name != null) {
      return false;
    }
    return useAge != null ? useAge.equals(tool.useAge) : tool.useAge == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (useAge != null ? useAge.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Tool{" +
        "name='" + name + '\'' +
        ", useAge='" + useAge + '\'' +
        '}';
  }
}
