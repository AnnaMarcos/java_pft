package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
public class ContactData {
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  private String fName;
  private String lName;
  private String address;
  private String homePhone;
  private String cellPhone;
  private String wPhone;
  private String email;
  private String email2;
  private String email3;
  private String allEmails;
  private String group;
  private String allPhones;
  private File photo;


  public File getPhoto() {
    return photo;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public int getId() {
    return id;
  }

  public String getAllPhones() {
    return allPhones;
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


  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(fName, that.fName) &&
            Objects.equals(lName, that.lName) &&
            Objects.equals(address, that.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, fName, lName, address);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", fName='" + fName + '\'' +
            ", lName='" + lName + '\'' +
            '}';
  }
}