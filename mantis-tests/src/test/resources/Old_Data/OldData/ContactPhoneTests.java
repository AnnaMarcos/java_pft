/*package ru.stqa.pft.mantis.tests.OldData;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.tests.OldData.model.ContactData;
import ru.stqa.pft.mantis.tests.tests.TestBase;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition(){
    app.goTo().homePage();
    if ( app.db().contacts().size() == 0){
      app.goTo().homePage();
      app.contact().create (new ContactData().withfName("Olga").withlName("Biyatova").withAddress("333 Heaven ave.").
              withHomePhone("+88888").withCellPhone("66666").withwPhone("77777").withEmail("bbbb@bbbbb.com")
              .withEmail2("aaa@nnn").withEmail3("ddd@nnn"),false);
    }
  }

  @Test
  public void TestContactPhones() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    MatcherAssert.assertThat(contact.getAllPhones(), CoreMatchers.equalTo(mergePhones(contactInfoFromEditForm)));

  }

  public String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(),contact.getCellPhone(),contact.getwPhone())
          .stream().filter((s) -> ! s.equals(""))
          .map(ContactPhoneTests::cleaned)
          .collect(Collectors.joining("\n"));

  }

  public static String cleaned (String phone) {
    return phone.replaceAll("\\s" , "").replaceAll("[-()]","");
  }
}


 */