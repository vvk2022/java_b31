package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.UserData;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void submitUserCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillUserForm(UserData userData, boolean creation) {
        type(By.name("firstname"), userData.getFirstname());
        type(By.name("lastname"), userData.getLastname());
        type(By.name("mobile"), userData.getMobile());
        type(By.name("email"), userData.getEmail());

        if(creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userData.getGroup());
        } else{
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void gotoUserPage() {
        click(By.linkText("add new"));
    }

    public void selectUser() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedUser() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void initUserModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitUserModification() {
        click(By.name("update"));
    }

    public boolean isThereAUser() {
        return(isElementPresent(By.name("entry")));
    }

    public void createUser(UserData userData) {
        gotoUserPage();
        fillUserForm(userData, true);
        submitUserCreation();
        gotoHomePage();
    }

    private void gotoHomePage() {
        click(By.linkText("home"));
    }
}