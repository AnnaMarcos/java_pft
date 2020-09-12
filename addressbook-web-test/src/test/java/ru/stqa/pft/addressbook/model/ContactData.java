package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String fName;
  private final String lName;
  private final String address;
  private final String hPhone;
  private final String cellPhone;
  private final String wPhone;
  private final String email;



  private String group;

  public ContactData(String fName, String lName, String address, String hPhone, String cellPhone, String wPhone, String email, String group) {
    this.fName = fName;
    this.lName = lName;
    this.address = address;
    this.hPhone = hPhone;
    this.cellPhone = cellPhone;
    this.wPhone = wPhone;
    this.email = email;
    this.group = group;
  }

  public String getGroup() {
      return group;
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
}
