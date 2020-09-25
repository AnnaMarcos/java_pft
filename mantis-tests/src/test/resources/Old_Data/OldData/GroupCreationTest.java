/*package ru.stqa.pft.mantis.tests.OldData;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.tests.OldData.model.GroupData;
import ru.stqa.pft.mantis.tests.OldData.model.Groups;
import ru.stqa.pft.mantis.tests.tests.TestBase;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {




  @DataProvider
  public Iterator<Object[]> validGroupsFromXml() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    try(BufferedReader reader =new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(GroupData.class);
      List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
      return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }
  @DataProvider
  public Iterator<Object[]> validGroupsFromJson() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    try (BufferedReader reader =new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {
      }.getType());
      return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }


  @Test(dataProvider = "validGroupsFromJson")
  public void testGroupCreation(GroupData group)  {

      app.goTo().groupPage();
      Groups before = app.db().groups();
      app.group().create(group);
      app.goTo().groupPage();
      assertThat(app.group().count(),equalTo (before.size() + 1));
      Groups after = app.db().groups();
      assertThat(after, equalTo(before.withAdded
              (group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));


    }


  @Test
  public void testBadGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before = app.db().groups();
    GroupData group = new GroupData() .withName("Test'");
    app.group().create(group);
    app.goTo().groupPage();
    assertThat(app.group().count(),equalTo (before.size()));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before));
    verifyGroupListInUI();
  }
}


 */