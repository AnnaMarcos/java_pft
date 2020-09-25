/*package ru.stqa.pft.mantis.tests.OldData;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.tests.OldData.model.GroupData;
import ru.stqa.pft.mantis.tests.OldData.model.Groups;
import ru.stqa.pft.mantis.tests.tests.TestBase;

public class GroupModificationTest extends TestBase {

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
    verifyGroupListInUI();
  }




}

 */
