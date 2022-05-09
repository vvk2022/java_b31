package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.UserData;

public class UserHelper {
    private WebDriver wd;

    public UserHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void submitUserCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillUserForm(UserData userData) {
        wd.findElement(By.name(userData.getFirstname())).click();
        wd.findElement(By.name(userData.getFirstname())).clear();
        wd.findElement(By.name(userData.getFirstname())).sendKeys("test1");
        wd.findElement(By.name(userData.getLastname())).click();
        wd.findElement(By.name(userData.getLastname())).clear();
        wd.findElement(By.name(userData.getLastname())).sendKeys("test3");
        wd.findElement(By.name(userData.getMobile())).click();
        wd.findElement(By.name(userData.getMobile())).clear();
        wd.findElement(By.name(userData.getMobile())).sendKeys("test9");
        wd.findElement(By.name(userData.getEmail())).click();
        wd.findElement(By.name(userData.getEmail())).clear();
        wd.findElement(By.name(userData.getEmail())).sendKeys("test12");
    }

    public void gotoUserPage() {
        wd.findElement(By.linkText("add new")).click();
    }
}
