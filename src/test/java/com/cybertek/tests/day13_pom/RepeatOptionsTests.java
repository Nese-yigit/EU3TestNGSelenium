package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTests extends TestBase {

  /*VERIFY RADIO BUTTONS
    Open browser
    Login as driver
    Go to Activities->Calendar Events
    Click on create calendar events
    Click on repeat
    Verify that repeat every days is checked
    verify that repeat weekday is not checked
    * */

    @Test
    public void test1(){

        LoginPage loginpage=new LoginPage();
       // Login as driver
        loginpage.loginAsDriver();

        DashboardPage dashboardPage=new DashboardPage();
        //  Go to Activities->Calendar Events
        dashboardPage.navigateToModule("Activities","Calendar Events");
        BrowserUtils.waitFor(3);
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        // Click on create calendar events
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
          // Click on repeat
        createCalendarEventsPage.repeat.click();

        //Verify that repeat every days is checked
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"verify repeat every days is checked");
        // verify that repeat weekday is not checked
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"verify weekday is not selected");
    }

    @Test
    public void test2(){

          /*
   VERIFY REPEAT OPTIONS
   Open browser
   Login as driver
   Go to Activities->Calendar Events
   Click on create calendar events button
   Click on repeat checkbox
   Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
*/
        LoginPage loginpage=new LoginPage();
        // Login as driver
        loginpage.loginAsDriver();

        DashboardPage dashboardPage=new DashboardPage();
        //  Go to Activities->Calendar Events
        dashboardPage.navigateToModule("Activities","Calendar Events");
        BrowserUtils.waitFor(3);
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        // Click on create calendar events
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        // Click on repeat checkbox
        createCalendarEventsPage.repeat.click();

        Select repeatsDropdown= createCalendarEventsPage.repeatOptionsList();


        // Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");

       List<String> actualList = new ArrayList<>();

        List<WebElement> actualOptions = repeatsDropdown.getOptions();
        for (WebElement option : actualOptions) {
            //get text of each element and add to actual List
            actualList.add(option.getText());
        }
        //ready method for getting text of list of web elements
       // List<String> actualList2 = BrowserUtils.getElementsText(actualOptions);
        //Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
        Assert.assertEquals(actualList,expectedList,"Verify Daily weekly monthly yearly");










    }



}
