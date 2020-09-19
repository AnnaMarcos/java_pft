package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTest extends TestBase {


    @Test
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.goTo().homePage();
    app.contact().create();
      File photo = new File("src/test/resources/cat.png");
      ContactData contact = (new ContactData().withfName("Olga").withlName("Biyatova").withPhoto(photo).withAddress("333 Heaven ave.").
            withHomePhone("+88888").withCellPhone("66666").withwPhone("77777").withEmail("bbbbbb@bbbbb.com").withGroup("Test"));
    app.contact().create(contact,true);
    app.goTo().homePage();
      assertThat(app.contact().count(),  equalTo (before.size() + 1));
      Contacts after = app.contact().all();
      assertThat(after,equalTo(before
              .withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }
  @Test (enabled = false)
  public void testCurrentDir() {
      File currentDir = new File(".");
      System.out.println(currentDir.getAbsolutePath());
      File photo = new File("src/test/resources/cat.png");
      System.out.println(currentDir.getAbsolutePath());
    System.out.println(photo.exists());


  }

}
