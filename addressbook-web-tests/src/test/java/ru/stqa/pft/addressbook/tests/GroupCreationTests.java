package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
        //wd.findElement(By.linkText("Logout")).click();
        //wd.findElement(By.name("user")).clear();
        //wd.findElement(By.name("user")).sendKeys("admin");
    }

}
