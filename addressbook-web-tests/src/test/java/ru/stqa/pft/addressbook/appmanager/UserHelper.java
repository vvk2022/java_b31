package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.ArrayList;
import java.util.List;

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

    public void selectUser(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedUser() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void initUserModification(int index) {
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
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

    public int getUserCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<UserData> getUserList() {
        List<UserData> users = new ArrayList<UserData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for(WebElement element : elements) {
            String[] userrecord = element.getText().split(" ");
            String lastname = userrecord[0];
            String firstname = userrecord[1];
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            UserData user = new UserData(id, firstname, lastname, null, null, null);
            users.add(user);
        }
        return users;
    }
}