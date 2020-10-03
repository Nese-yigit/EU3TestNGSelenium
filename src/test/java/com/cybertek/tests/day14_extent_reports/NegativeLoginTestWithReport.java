package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest() {

        //name of test
        extentLogger= report.createTest("Wrong password Test");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter UserName :user1");
        loginPage.usernameInput.sendKeys("user1");

        extentLogger.info("Enter Password: somepassword");
        loginPage.passwordInput.sendKeys("somepassword");

        extentLogger.info("Enter Login button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify page Url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.info("Wrong Password Test is passed");
    }

    @Test
    public void wrongUsernameTest(){

        extentLogger= report.createTest("Wrong UserName Test");
        
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter username: someusername");
        loginPage.usernameInput.sendKeys("someusername");

        extentLogger.info("Enter password: UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("Click Login button");
        loginPage.loginBtn.click();

        extentLogger.info("verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("PASSED");

    }






}
