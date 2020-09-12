package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Christian", "Silantyev", "111Ash ave.",
              "111111111", "222222222","33333333", "aaaaa@bbbbb.com", "Test4"), true);
    }
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("Svetlana", "Marcos", "222 Holy ave.",
            "44444444", "555555555", "666666666", "bbbbb@ccccc.com", null), false);
    app.getContactHelper().updateContact();
    app.getNavigationHelper().returnToHomePage();
    app.logout();



  }
}
