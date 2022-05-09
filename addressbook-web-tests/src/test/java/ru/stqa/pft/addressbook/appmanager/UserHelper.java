package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.UserData;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void submitUserCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillUserForm(UserData userData) {
        type(By.name(userData.getFirstname()), userData.getFirstname());
        type(By.name(userData.getLastname()), userData.getLastname());
        type(By.name(userData.getMobile()), userData.getMobile());
        type(By.name(userData.getEmail()), userData.getEmail());
    }

    public void gotoUserPage() {
        click(By.linkText("add new"));
    }
}
