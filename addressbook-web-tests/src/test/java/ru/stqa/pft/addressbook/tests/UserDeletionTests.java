package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class UserDeletionTests extends TestBase {

    @Test
    public void testUserDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getUserHelper().isThereAUser()) {
            app.getUserHelper().createUser(new UserData("test1", "test2", "test3", null, "[none]"));
        }
        app.getUserHelper().selectUser();
        app.getUserHelper().deleteSelectedUser();
        app.closeAlert();
        app.getNavigationHelper().gotoHomePage();
    }

}
