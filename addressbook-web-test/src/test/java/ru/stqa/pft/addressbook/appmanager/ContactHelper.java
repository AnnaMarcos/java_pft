package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submit() {
    click(By.xpath("(//input[@name='submit'])[2]"));
   // wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getfName());
    type(By.name("lastname"), contactData.getlName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getCellPhone());
    type(By.name("work"), contactData.getwPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    attach(By.name("photo"), contactData.getPhoto());


    if ( creation ) {
      if (contactData.getGroups().size() > 0) {
        Assert.assertTrue(contactData.getGroups().size() ==1);
        new Select(wd.findElement(By.name("new_group")))
                .selectByVisibleText(contactData.getGroups().iterator().next().getName());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }


   /*if(creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups(groups));
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

    */




  public void selectAlert(){
    assert (true);
  }

  public void switchTo() {
    wd.switchTo().alert().accept();
  }

  public void add_new() {
   click(By.linkText("add new"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectContactById(int id) {click(By.cssSelector("input[value= '" + id +"' ]"));
  }

  public void contactDeletionVerification() {
    wd.switchTo().alert().accept();
    wd.findElement(By.cssSelector("div.msgbox"));
  }

  public void editContactById(int id) {
    click(By.cssSelector("img[alt=\"Edit\"]"));
  }

  public void updateContact() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void create(ContactData contact, boolean creation) {
    add_new();
    fillContactForm (contact, creation);
    submit();

  }

  public void modify(ContactData contact) {
    editContactById(contact.getId());
    fillContactForm(contact, false);
    updateContact();
    contactCache = null;
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    contactDeletionVerification();
    contactCache = null;
  }

  public boolean isThereAContact() {
    return  isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return  wd.findElements(By.name("selected[]")).size();
  }

  public void addToGroup(ContactData contact, GroupData group) {
    selectContactById(contact.getId());
    new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(group.getName());
    wd.findElement(By.name("add")).click();
  }

  public void removeFromGroup(ContactData contact, GroupData group) {
    new Select(wd.findElement(By.cssSelector("select[name=group]"))).selectByVisibleText(group.getName());
    selectContactById(contact.getId());
    wd.findElement(By.name("remove")).click();
  }



  public Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> rows  = wd.findElements(By.name("entry"));
    for (WebElement row :rows) {
      List<WebElement> cells = row.findElements(By.cssSelector("td"));
      String lName = cells.get(1).getText();
      String fName = cells.get(2).getText();
      String address = cells.get(3).getText();
     // String allEmails = cells.get(4).getText();
      //String allPhones = cells.get(5).getText();
      String homePhone = cells.get(4).getText();
      String cellPhone = cells.get(5).getText();
      String wPhone = cells.get(6).getText();
      String email = cells.get(7).getText();
      String email2 = cells.get(8).getText();
      String email3 = cells.get(9).getText();


      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withfName(fName).withlName(lName).withAddress(address)
              .withEmail(email).withEmail2(email2).withEmail3(email3).withHomePhone(homePhone).withCellPhone(cellPhone)
              .withwPhone(wPhone));
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String fName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lName = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String homePhone = wd.findElement(By.name("home")).getAttribute("value");
    String cellPhone = wd.findElement(By.name("mobile")).getAttribute("value");
    String wPhone = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return  new ContactData().withId(contact.getId()).withfName(fName).withlName(lName).withAddress(address)
            .withEmail(email).withEmail2(email2).withEmail3(email3).withHomePhone(homePhone)
            .withCellPhone(cellPhone).withwPhone(wPhone);
  }

  public void initContactModificationById(int id) {
    //WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value= '%s']", id)));
    //WebElement row = checkbox.findElement(By.xpath("./../.."));
   // List<WebElement> cells = row.findElements((By.tagName("td")));
   // cells.get(7).findElement(By.tagName("a")).click();
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }
}
