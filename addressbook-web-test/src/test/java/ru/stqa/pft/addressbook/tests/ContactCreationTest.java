package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTest extends TestBase {


    @Test
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.goTo().homePage();
    app.contact().create();
    ContactData contact = (new ContactData().withfName("Olga").withlName("Biyatova").withAddress("333 Heaven ave.").
            withHomePhone("+88888").withCellPhone("66666").withwPhone("77777").withEmail("bbbbbb@bbbbb.com").withGroup("Test"));
    app.contact().create(contact,true);
    app.goTo().homePage();
      assertThat(app.contact().count(),  equalTo (before.size() + 1));
      Contacts after = app.contact().all();
      assertThat(after,equalTo(before
              .withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }


}
