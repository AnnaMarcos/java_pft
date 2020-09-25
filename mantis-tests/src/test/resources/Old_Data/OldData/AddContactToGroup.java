/*package ru.stqa.pft.mantis.tests.OldData;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.tests.OldData.model.ContactData;
import ru.stqa.pft.mantis.tests.OldData.model.GroupData;
import ru.stqa.pft.mantis.tests.OldData.model.Groups;
import ru.stqa.pft.mantis.tests.tests.TestBase;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class AddContactToGroup extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {

    if ( app.db().contacts().stream().filter(e -> (e.getGroups().isEmpty())).collect(Collectors.toSet()).size() == 0 ) {
      app.contact().create(new ContactData().withfName("Olga").withlName("Biyatova").withAddress("333 Heaven ave.").
              withHomePhone("88888").withCellPhone("66666").withwPhone("77777").withEmail("bbbb@bbbbb.com")
              .withEmail2("aaa@nnn").withEmail3("ddd@nnn"), true);
    }
      if ( app.db().groups().size() == 0 ) {
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("test"));
      }
    }
  @Test
  public void testAddContactToGroup() {
    app.goTo().homePage();
    Groups groups = app.db().groups();
    GroupData group = groups.iterator().next();
    ContactData contact = app.db().contacts().stream().filter(c -> (c.getGroups().isEmpty()))
            .collect(toSet()).iterator().next();
    app.contact().addToGroup(contact, group);
    app.goTo().homePage();
    int contactId = contact.getId();
    contact = app.db().contacts().
            stream().filter(c -> (c.getId() == contactId)).collect(toSet()).iterator().next();
    assertThat(contact.getGroups(), contains(group));
  }
}

 */



