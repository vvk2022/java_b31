package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserAddTests extends TestBase {

    @Test
    public void testUserAdd() throws Exception {
        app.returnToHomePage();
        Users before = app.user().all();
        UserData user = new UserData().withFirstname("test2").withLastname("test3");
        app.user().create(user);
        app.returnToHomePage();
        Users after = app.user().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(
                before.withAdded(user.withId(after.stream().mapToInt((u) -> u.getId()).max().getAsInt()))));
    }

}
