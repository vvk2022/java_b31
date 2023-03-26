package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class UserDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions () {
        app.returnToHomePage();
        if (app.user().all().size() == 0) {
            app.user().create(new UserData().withFirstname("test1").withLastname("test2"));
        }
    }

    @Test
    public void testUserDeletion() {
        Users before = app.user().all();
        UserData deletedUser = before.iterator().next();
        app.user().delete(deletedUser);
//        app.closeAlert();
//        app.returnToHomePage();
        Users after = app.user().all();
        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.withOut(deletedUser)));
    }
}
