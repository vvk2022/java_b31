package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.UserData;

public class UserAddTests extends TestBase {

    @Test
    public void testUserAdd() throws Exception {
        app.getUserHelper().gotoUserPage();
        app.getUserHelper().fillUserForm(new UserData("firstname", "lastname", "mobile", "email","test1"), true);
        app.getUserHelper().submitUserCreation();
        app.returnToHomePage();
    }

}
