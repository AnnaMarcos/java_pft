package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private  int id;
  private final String fName;
  private final String lName;
  private final  String address;
  private final String hPhone;
  private final String cellPhone;
  private final String wPhone;
  private final String email;
  private String group;


  public ContactData(int id, String fName, String lName, String address, String hPhone, String cellPhone, String wPhone, String email, String group) {
    this.id = id;
    this.fName = fName;
    this.lName = lName;
    this.address = address;
    this.hPhone = hPhone;
    this.cellPhone = cellPhone;
    this.wPhone = wPhone;
    this.email = email;
    this.group = group;
  }



  public ContactData(String fName, String lName, String address, String hPhone, String cellPhone, String wPhone, String email, String group) {
    this.id = Integer.MAX_VALUE;
    this.fName = fName;
    this.lName = lName;
    this.address = address;
    this.hPhone = hPhone;
    this.cellPhone = cellPhone;
    this.wPhone = wPhone;
    this.email = email;
    this.group = group;
  }


  public int getId() {
    return id;
  }

  public String getfName() {
    return fName;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getlName() {
    return lName;
  }

  public String getAddress() {
    return address;
  }

  public String gethPhone() {
    return hPhone;
  }

  public String getCellPhone() {
    return cellPhone;
  }

  public String getwPhone() {
    return wPhone;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", fName='" + fName + '\'' +
            ", lName='" + lName + '\'' +
            ", address='" + address + '\'' +
            '}';
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(fName, that.fName) &&
            Objects.equals(lName, that.lName) &&
            Objects.equals(address, that.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fName, lName, address);
  }

}
