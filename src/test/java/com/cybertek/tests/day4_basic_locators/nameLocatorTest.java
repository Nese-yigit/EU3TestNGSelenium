package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("Chrome");

        //make browser fullscreen
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        Thread.sleep(2000);
        WebElement fullNameInput= driver.findElement(By.name("full_name"));
        fullNameInput.sendKeys("Mike Smith");

        Thread.sleep(2000);
        //put some email and click sign up
        //proper way
        WebElement email= driver.findElement(By.name("email"));
        email.sendKeys("mike@cybertek.com");

        //lazy way
        //driver.findElement(By.name("email")).sendKeys("mike@smith.com");
        driver.findElement(By.name("wooden_spoon")).click();



    }


}
