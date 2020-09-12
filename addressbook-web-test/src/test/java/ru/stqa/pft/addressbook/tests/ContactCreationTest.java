package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {


    @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().createContact(new ContactData("Christian", "Silantyev", "111Ash ave.",
            "111111111", "222222222","33333333", "aaaaa@bbbbb.com", "Test4"), true);
    app.logout();
  }


}
