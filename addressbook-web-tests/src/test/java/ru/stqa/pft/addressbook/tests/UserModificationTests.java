package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

import java.util.Comparator;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class UserModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions () {
        app.returnToHomePage();
        if (app.user().all().size() == 0) {
            app.user().create(new UserData().withFirstname("test1").withLastname("test2"));
        }
    }

    @Test (enabled = true)
    public void testUserModification() {
        app.returnToHomePage();
        Users before = app.user().all();
        UserData modifiedUser = before.iterator().next();
        UserData user = new UserData()
                .withId(modifiedUser.getId()).withFirstname("firstname_modified").withLastname("lastname_modified").withMobile("mobile_modified").withEmail("email_modified");
        app.user().modify(user);
        Users after = app.user().all();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.withOut(modifiedUser).withAdded(user)));
    }
}
