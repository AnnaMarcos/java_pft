package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private  int id =  Integer.MAX_VALUE;
  private  String fName;
  private  String lName;
  private  String address;
  private  String homePhone;
  private  String cellPhone;
  private  String wPhone;
  private  String email;
  private  String group;



  public int getId() {
    return id;
  }

  public String getfName() {
    return fName;
  }


  public String getlName() {
    return lName;
  }

  public String getAddress() {
    return address;
  }



  public String getHomePhone() {
    return homePhone;
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


  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withfName(String fName) {
    this.fName = fName;
    return this;
  }

  public ContactData withlName(String lName) {
    this.lName = lName;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withCellPhone(String cellPhone) {
    this.cellPhone = cellPhone;
    return this;
  }

  public ContactData withwPhone(String wPhone) {
    this.wPhone = wPhone;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }
  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", fName='" + fName + '\'' +
            ", lName='" + lName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(fName, that.fName) &&
            Objects.equals(lName, that.lName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, fName, lName);
  }

}
