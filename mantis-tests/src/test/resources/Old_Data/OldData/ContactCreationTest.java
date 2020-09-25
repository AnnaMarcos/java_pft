/*package ru.stqa.pft.mantis.tests.OldData;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.tests.OldData.model.ContactData;
import ru.stqa.pft.mantis.tests.OldData.model.Contacts;
import ru.stqa.pft.mantis.tests.OldData.model.Groups;
import ru.stqa.pft.mantis.tests.tests.TestBase;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
public class ContactCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]>validContactsFromXml() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
      try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
        String xml = "";
        String line = reader.readLine();
        while (line != null) {
          xml += line;
          line = reader.readLine();
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
        return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
      }
    }

    @DataProvider
    public Iterator<Object[]>validContactsFromJson() throws IOException {
      List<Object[]> list = new ArrayList<Object[]>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
          String json = "";
          String line = reader.readLine();
          while (line != null) {
            json += line;
            line = reader.readLine();
          }
          Gson gson = new Gson();
          List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
          }.getType());
          return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
        }
      }


      @Test (dataProvider = "validContactsFromJson" )
      public void testContactCreation(ContactData contact) {

        Groups groups = app.db().groups();
        Contacts before = app.db().contacts();
        File photo = new File("src/test/resources/cat.png");
        ContactData newContact = new ContactData().withfName("Olga").withlName("Biyatova").withAddress("333 Heaven ave.").
                withHomePhone("88888").withCellPhone("66666").withwPhone("77777").withEmail("bbbb@bbbbb.com")
                .withEmail2("aaa@nnn").withEmail3("ddd@nnn").withPhoto(photo).inGroup(groups.iterator().next());
        app.goTo().homePage();
        app.contact().create(newContact, true);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before
                .withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
        verifyContactListInUI();
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

 */