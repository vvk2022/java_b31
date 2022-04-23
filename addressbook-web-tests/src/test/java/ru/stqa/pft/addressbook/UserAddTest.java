package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UserAddTest {
    private WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/edit.php");
        login("admin", "secret");
    }

    private void login(String username, String password) {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.id("LoginForm")).click();
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Test
    public void testUserAdd() throws Exception {
        gotoUserPage();
        fillUserForm(new UserData("firstname", "lastname", "mobile", "email"));
        submiUserCreation();
        returnToHomePage();
//        wd.findElement(By.linkText("Logout")).click();
//        wd.findElement(By.name("user")).clear();
//        wd.findElement(By.name("user")).sendKeys("admin");
    }

    private void returnToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    private void submiUserCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    private void fillUserForm(UserData userData) {
        wd.findElement(By.name(userData.getFirstname())).click();
        wd.findElement(By.name(userData.getFirstname())).clear();
        wd.findElement(By.name(userData.getFirstname())).sendKeys("test1");
//        wd.findElement(By.name("middlename")).click();
//        wd.findElement(By.name("middlename")).clear();
//        wd.findElement(By.name("middlename")).sendKeys("test2");
        wd.findElement(By.name(userData.getLastname())).click();
        wd.findElement(By.name(userData.getLastname())).clear();
        wd.findElement(By.name(userData.getLastname())).sendKeys("test3");
//        wd.findElement(By.name("nickname")).click();
//        wd.findElement(By.name("nickname")).clear();
//        wd.findElement(By.name("nickname")).sendKeys("test4");
//        wd.findElement(By.name("title")).click();//
//        wd.findElement(By.name("title")).clear();
//        wd.findElement(By.name("title")).sendKeys("test5");
//        wd.findElement(By.name("company")).click();
//        wd.findElement(By.name("company")).clear();
//        wd.findElement(By.name("company")).sendKeys("test6");
//        wd.findElement(By.name("address")).click();
//        wd.findElement(By.name("address")).clear();
//        wd.findElement(By.name("address")).sendKeys("test7");
//        wd.findElement(By.name("home")).click();
//        wd.findElement(By.name("home")).clear();
//        wd.findElement(By.name("home")).sendKeys("test8");
        wd.findElement(By.name(userData.getMobile())).click();
        wd.findElement(By.name(userData.getMobile())).clear();
        wd.findElement(By.name(userData.getMobile())).sendKeys("test9");
//        wd.findElement(By.name("work")).click();
//        wd.findElement(By.name("work")).clear();
//        wd.findElement(By.name("work")).sendKeys("test10");
//        wd.findElement(By.name("fax")).click();
//        wd.findElement(By.name("fax")).clear();
//        wd.findElement(By.name("fax")).sendKeys("test11");
        wd.findElement(By.name(userData.getEmail())).click();
        wd.findElement(By.name(userData.getEmail())).clear();
        wd.findElement(By.name(userData.getEmail())).sendKeys("test12");
//        wd.findElement(By.name("email2")).click();
//        wd.findElement(By.name("email2")).clear();
//        wd.findElement(By.name("email2")).sendKeys("test13");
//        wd.findElement(By.name("email3")).click();
//        wd.findElement(By.name("email3")).clear();
//        wd.findElement(By.name("email3")).sendKeys("test14");
//        wd.findElement(By.name("homepage")).click();
//        wd.findElement(By.name("homepage")).clear();
//        wd.findElement(By.name("homepage")).sendKeys("test15");
//        wd.findElement(By.name("bday")).click();
//        new Select(wd.findElement(By.name("bday"))).selectByVisibleText("1");
//        wd.findElement(By.xpath("//option[@value='1']")).click();
//        wd.findElement(By.name("bmonth")).click();
//        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText("January");
//        wd.findElement(By.xpath("//option[@value='January']")).click();
//        wd.findElement(By.name("byear")).click();
//        wd.findElement(By.name("byear")).clear();
//        wd.findElement(By.name("byear")).sendKeys("2000");
//        wd.findElement(By.name("theform")).click();
//        wd.findElement(By.name("address2")).click();
//        wd.findElement(By.name("address2")).clear();
//        wd.findElement(By.name("address2")).sendKeys("test16");
//        wd.findElement(By.name("phone2")).click();
//        wd.findElement(By.name("phone2")).clear();
//        wd.findElement(By.name("phone2")).sendKeys("test17");
//        wd.findElement(By.name("notes")).click();
//        wd.findElement(By.name("notes")).clear();
//        wd.findElement(By.name("notes")).sendKeys("test18");
//        wd.findElement(By.name("aday")).click();
//        new Select(wd.findElement(By.name("aday"))).selectByVisibleText("1");
//        wd.findElement(By.xpath("//div[@id='content']/form/select[3]/option[3]")).click();
//        wd.findElement(By.name("amonth")).click();
//        new Select(wd.findElement(By.name("amonth"))).selectByVisibleText("January");
//        wd.findElement(By.xpath("//div[@id='content']/form/select[4]/option[2]")).click();
//        wd.findElement(By.name("ayear")).click();
//        wd.findElement(By.name("ayear")).clear();
//        wd.findElement(By.name("ayear")).sendKeys("2000");
//        wd.findElement(By.name("new_group")).click();
//        wd.findElement(By.xpath("//option[@value='[none]']")).click();
    }

    private void gotoUserPage() {
        wd.findElement(By.linkText("add new")).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        wd.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

}
