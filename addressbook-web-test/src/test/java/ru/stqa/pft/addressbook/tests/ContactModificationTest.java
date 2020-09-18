package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase{

  @BeforeMethod
  public void ensurePrecondition(){
    app.goTo().homePage();
    if ( app.contact().all().size() == 0){
      app.contact().create (new ContactData().withfName("Olga").withlName("Biyatova").withAddress("333 Heaven ave.").
              withHomePhone("+88888").withCellPhone("66666").withwPhone("77777").withEmail("bbbbbb@bbbbb.com").withGroup("Test"),true);
    }
  }

  @Test
  public void testContactModification() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact =  (new ContactData().withId(modifiedContact.getId()).withfName("Chris")
            .withlName("Silantyev").withAddress("777 Sun ave.").withHomePhone("+00000").withCellPhone("11111111")
            .withwPhone("2222").withEmail("ccccc@sssss.com"));
    app.contact().modify(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(),  equalTo (before.size()));
    Contacts after = app.contact().all();
    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.withOut(modifiedContact).withAdded(contact)));




  }


}