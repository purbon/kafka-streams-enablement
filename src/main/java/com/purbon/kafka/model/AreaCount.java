package com.purbon.kafka.model;

import java.util.Objects;

public class AreaCount {

  private String area;
  private Long count;

  public AreaCount() {
    this("");
  }

  public AreaCount(String area) {
    this.area = area;
    this.count = 0L;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public void increaseByOneCount() {
    this.count += 1;
  }

  @Override
  public String toString() {
    return "AreaCount{" +
        "area='" + area + '\'' +
        ", count=" + count +
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
    AreaCount areaCount = (AreaCount) o;
    return Objects.equals(area, areaCount.area) &&
        Objects.equals(count, areaCount.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(area, count);
  }
}
