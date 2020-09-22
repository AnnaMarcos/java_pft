package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TestBase {


  Logger logger = LoggerFactory.getLogger(TestBase.class);

  public static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

  public ApplicationManager getApp() {
    return app;
  }

  @BeforeMethod(alwaysRun = true)
  public void logTestStart(Method m, Object[] p) {
    logger.info("Start test " + m.getName() + "with parameters" + Arrays.asList(p));

  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m) {
    logger.info("Stop test " + m.getName());

  }

  public void verifyGroupListInUI() {
    Groups dbGroups = app.db().groups();
    Groups uiGroups = app.group().all();
    MatcherAssert.assertThat(uiGroups, CoreMatchers.equalTo(dbGroups.stream()
            .map((g) -> new GroupData().withId(g.getId()).withName(g.getName())).collect(Collectors.toSet())));
  }


  public void verifyContactListInUI() {
    Contacts dbContacts = app.db().contacts();
    Contacts uiContacts = app.contact().all();
    MatcherAssert.assertThat(uiContacts, CoreMatchers.equalTo(dbContacts.stream()
            .map((c) -> new ContactData().withId(c.getId()).withfName(c.getfName()).withlName(c.getlName())
                  .withAddress(c.getAddress()).withHomePhone(c.getHomePhone()).withCellPhone(c.getCellPhone())
                    .withwPhone(c.getwPhone()).withEmail(c.getEmail()).withEmail2(c.getEmail2())
                    .withEmail3(c.getEmail3()).withPhoto(c.getPhoto())).collect(Collectors.toSet())));


  }
}

