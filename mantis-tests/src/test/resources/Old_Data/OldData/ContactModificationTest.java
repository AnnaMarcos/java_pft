/*package ru.stqa.pft.mantis.tests.OldData;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.tests.OldData.model.ContactData;
import ru.stqa.pft.mantis.tests.OldData.model.Contacts;
import ru.stqa.pft.mantis.tests.tests.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePrecondition(){
    app.goTo().homePage();
    if ( app.db().contacts().size() == 0){
      app.goTo().homePage();
      app.contact().create (new ContactData().withfName("Olga").withlName("Biyatova").withAddress("333 Heaven ave.").
              withHomePhone("88888").withCellPhone("66666").withwPhone("77777").withEmail("bbbb@bbbbb.com")
              .withEmail2("aaa@nnn").withEmail3("ddd@nnn"),true);
    }
  }

  @Test
  public void testContactModification() {
    if (Boolean.getBoolean("verifyUI")) {
      app.goTo().homePage();
      Contacts before = app.db().contacts();
      ContactData modifiedContact = before.iterator().next();
      ContactData contact = (new ContactData().withId(modifiedContact.getId()).withfName("Chris")
              .withlName("Silantyev").withAddress("777 Sun ave.").withHomePhone("+000").withCellPhone("11111111")
              .withwPhone("2222").withEmail("ccccc@sssss.com").withEmail2("fff@fd.com").withEmail3("ddd@bbb.ru"));
      app.contact().modify(contact);
      app.goTo().homePage();
      Assert.assertEquals(app.contact().count(), before.size());
      Contacts after = app.db().contacts();
      MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.withOut(modifiedContact).withAdded(contact)));
      verifyContactListInUI();
    }
  }
}


 */