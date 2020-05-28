package com.purbon.kafka.model;

public class LabResult {

  private String personId;
  private String area;
  private Boolean positive;

  public String getPersonId() {
    return personId;
  }

  public void setPersonId(String personId) {
    this.personId = personId;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public Boolean getPositive() {
    return positive;
  }

  public void setPositive(Boolean positive) {
    this.positive = positive;
  }

  @Override
  public String toString() {
    return "LabResult{" +
        "personId='" + personId + '\'' +
        ", area='" + area + '\'' +
        ", positive=" + positive +
        '}';
  }
}
