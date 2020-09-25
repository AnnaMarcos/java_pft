/*package ru.stqa.pft.mantis.tests.OldData;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.tests.OldData.model.ContactData;
import ru.stqa.pft.mantis.tests.OldData.model.Contacts;
import ru.stqa.pft.mantis.tests.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePrecondition(){
    app.goTo().homePage();
    if ( app.db().contacts().size() == 0){
      app.goTo().homePage();
      app.contact().create (new ContactData().withfName("Olga").withlName("Biyatova").withAddress("333 Heaven ave.").
              withHomePhone("+88888").withCellPhone("66666").withwPhone("77777").withEmail("bbbb@bbbbb.com")
              .withEmail2("aaa@nnn").withEmail3("ddd@nnn"), true);
    }
  }

  @Test
  public void testContactDeletion() throws Exception {
    app.goTo().homePage();
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    assertThat(app.contact().count(),  equalTo (before.size() - 1));
    Contacts after = app.db().contacts();
    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.withOut(deletedContact)));
    verifyContactListInUI();
  }



}


 */