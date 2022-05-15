package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class UserDeletionTests extends TestBase {

    @Test
    public void testUserDeletion() {
        app.getNavigationHelper().gotoHomePage();
        app.getUserHelper().selectUser();
        app.getUserHelper().deleteSelectedUser();
        app.closeAlert();
        app.getNavigationHelper().gotoHomePage();
    }

}
