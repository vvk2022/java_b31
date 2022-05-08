package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class UserAddTest extends TestBase {

    @Test
    public void testUserAdd() throws Exception {
        gotoUserPage();
        fillUserForm(new UserData("firstname", "lastname", "mobile", "email"));
        submitUserCreation();
        returnToHomePage();
    }

}
