package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePrecondition(){
    if(app.db().groups().size() == 0){
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("Test"));
    }
  }

  @Test
  public void testGroupDeletion() {
    app.goTo().groupPage();
    Groups before = app.db().groups();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Assert.assertEquals(app.group().count(), before.size() - 1);
    Groups after =  app.db().groups();
    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.withOut(deletedGroup)));

    }



}

