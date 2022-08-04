package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class UserModificationTests extends TestBase {

    @Test
    public void testUserModification() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getUserHelper().isThereAUser()) {
            app.getUserHelper().createUser(new UserData("test1", "test2", "test3", null, "[none]"));
        }
        app.getUserHelper().initUserModification();
        app.getUserHelper().fillUserForm(new UserData("firstname_modified", "lastname_modified", "mobile_modified", "email_modified", null), false);
        app.getUserHelper().submitUserModification();
        app.returnToHomePage();
    }
}
