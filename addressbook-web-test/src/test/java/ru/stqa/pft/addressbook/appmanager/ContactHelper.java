package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getfName());
    type(By.name("lastname"), contactData.getlName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.gethPhone());
    type(By.name("mobile"), contactData.getCellPhone());
    type(By.name("work"), contactData.getwPhone());
    type(By.name("email"), contactData.getEmail());

    if(creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void deleteSelectedContact() {
    wd.findElement(By.xpath("//input[@value='Delete']")).click();
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void contactDeletionVerification() {
    wd.switchTo().alert().accept();
    wd.findElement(By.cssSelector("div.msgbox"));
  }

  public void editContact(int index) {
    wd.findElements(By.cssSelector("img[alt=\"Edit\"]")).get(index).click();

  }

  public void updateContact() {
    wd.findElement(By.xpath("(//input[@name='update'])[2]")).click();
  }

  public void createContact(ContactData contact,boolean creation) {
   initContactCreation();
   fillContactForm (contact,creation);
   submitContactCreation();

  }
  public boolean isThereAContact() {
    return  isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return  wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> rows  = wd.findElements(By.name("entry"));
    for (WebElement row :rows) {
      List<WebElement> cells = row.findElements(By.cssSelector("td"));
      String lName = cells.get(1).getText();
      String fName = cells.get(2).getText();
      String address = cells.get(3).getText();
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));

      ContactData contact = new ContactData( id, fName, lName, address, null,null,null,null,null );
      contacts.add(contact);
    }
    return contacts;


  }

  }
