package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTest extends TestBase {


  @DataProvider
  public Iterator<Object[]>validContacts() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    List<ContactData> contacts = (List<ContactData>)xstream.fromXML(xml);
    return contacts.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();

  }


    @Test( dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
        File photo = new File("src/test/resources/cat.png");
        app.goTo().homePage();
        Contacts before = app.contact().all();
        app.goTo().homePage();
        app.contact().create();
        app.contact().create(contact,true);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before
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
