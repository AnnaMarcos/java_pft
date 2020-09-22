package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupModificationTest extends TestBase{

  @BeforeMethod
  public void ensurePrecondition(){
    if(app.db().groups().size() == 0){
    app.goTo().groupPage();
      app.group().create(new GroupData().withName("Test"));
    }
  }

  @Test
  public void testGroupModification() {
    app.goTo().groupPage();
    Groups before = app.db().groups();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData().withId(modifiedGroup.getId())
            .withName("Test").withHeader("Test").withFooter("Test");
    app.goTo().groupPage();
    app.group().modify(group);
    Assert.assertEquals(app.group().count(), before.size());
    Groups after = app.db().groups();
    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.withOut(modifiedGroup).withAdded(group)));
  }


}
