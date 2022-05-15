package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.HelperBase;
import ru.stqa.pft.addressbook.model.UserData;

public class UserModificationTests extends TestBase {

    @Test
    public void testUserModification () {
        app.getNavigationHelper().gotoHomePage();
        app.getUserHelper().selectUser();
        app.getUserHelper().initUserModification();
        app.getUserHelper().fillUserForm(new UserData("firstname_modified", "lastname_modified", "mobile_modified", "email_modified"));
        app.getUserHelper().submitUserModification();
        app.returnToHomePage();
    }
}
