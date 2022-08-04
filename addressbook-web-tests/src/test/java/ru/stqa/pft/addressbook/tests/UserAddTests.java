package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.UserData;

public class UserAddTests extends TestBase {

    @Test
    public void testUserAdd() throws Exception {
        app.getUserHelper().createUser(new UserData("test1", "test2", "test3", null, "[none]"));
        app.returnToHomePage();
    }

}
