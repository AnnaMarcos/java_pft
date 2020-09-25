/*package ru.stqa.pft.mantis.tests.OldData.model;
import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
  @Table(name = "addressbook")
  @XStreamAlias("contact")
public class ContactData {

  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  private String fName;

  @Expose
  @Column(name = "lastname")
  private String lName;

  @Column(name = "address")
  @Type(type = "text")
  private String address;


  @Column(name = "home")
  @Type(type = "text")
  private String homePhone;


  @Column(name = "mobile")
  @Type(type = "text")
  private String cellPhone;


  @Column(name = "work")
  @Type(type = "text")
  private String wPhone;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String email;


  @Column(name = "email2")
  @Type(type = "text")
  private String email2;


  @Column(name = "email3")
  @Type(type = "text")
  private String email3;

  @Transient
  private String allEmails;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable (name = "address_in_groups", joinColumns = @JoinColumn (name = "id"),
          inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

  @Transient
  private String allPhones;

  @Column(name = "photo")
  @Type(type = "text")
  private String photo = "";

  public File getPhoto() {
    return new File (photo) ;
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

  public Groups getGroups() {
    return new Groups(groups);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
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

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      ContactData that = (ContactData) o;
      return id == that.id &&
              Objects.equals(fName, that.fName) &&
              Objects.equals(lName, that.lName) &&
              Objects.equals(address, that.address) &&
              Objects.equals(homePhone, that.homePhone) &&
              Objects.equals(cellPhone, that.cellPhone) &&
              Objects.equals(wPhone, that.wPhone) &&
              Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
      return Objects.hash(id, fName, lName, address, homePhone, cellPhone, wPhone, email);
    }

    @Override
    public String toString() {
      return "ContactData{" +
              "id=" + id +
              ", fName='" + fName + '\'' +
              ", lName='" + lName + '\'' +
              ", address='" + address + '\'' +
              '}';
    }
    public ContactData inGroup(GroupData group) {
    groups.add(group);
    return this;
    }


}

 */