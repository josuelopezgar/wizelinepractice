package TestCases;

import BaseFrameworkClasses.BaseSeleniumActions;
import BaseFrameworkClasses.GetEnvironment;
import BaseFrameworkClasses.SingletonBaseDriverReports;
import Pages.LoginPage;
import Pages.MyNotesPage;
import Pages.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class MainLoginScript {
    GetEnvironment getEnvironment = new GetEnvironment();
    WelcomePage welcomePage = new WelcomePage();
    BaseSeleniumActions baseSeleniumActions = new BaseSeleniumActions();
    LoginPage loginPage = new LoginPage();
    MyNotesPage myNotesPage = new MyNotesPage();
    WebDriver driver = SingletonBaseDriverReports.getDriver();

    @BeforeTest
    public void before(){
        baseSeleniumActions.openBrowser(driver,getEnvironment.getHost());
    }

    @Test(testName = "Openining login page")
    public void test(){
        welcomePage.clickOnButton(driver);
        loginPage.loginPage(driver);
        Assert.assertTrue(myNotesPage.validation(driver),"The my notes is visible");
    }

    @AfterTest
    public void after() throws IOException {
        driver.close();
        driver.quit();
        SingletonBaseDriverReports.getInstance().endTest();
    }
}
