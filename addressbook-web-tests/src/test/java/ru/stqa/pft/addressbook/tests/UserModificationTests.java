package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class UserModificationTests extends TestBase {

    @Test
    public void testUserModification() {
        app.returnToHomePage();
        if (!app.getUserHelper().isThereAUser()) {
            app.getUserHelper().createUser(new UserData("test1", "test2", "test3", null, "[none]"));
        }
        List<UserData> before = app.getUserHelper().getUserList();
        app.getUserHelper().initUserModification(before.size() - 1);
        UserData user = new UserData(before.get(before.size()-1).getId(), "firstname_modified", "lastname_modified", "mobile_modified", "email_modified", null);
        app.getUserHelper().fillUserForm(user, false);
        app.getUserHelper().submitUserModification();
        app.returnToHomePage();
        List<UserData> after = app.getUserHelper().getUserList();

        before.remove(before.size() - 1);
        before.add(user);
        Comparator<? super UserData> byId = (u1, u2) -> Integer.compare(u1.getId(), u2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
