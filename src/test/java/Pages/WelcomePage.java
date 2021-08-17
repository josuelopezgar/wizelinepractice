package Pages;

import BaseFrameworkClasses.BaseSeleniumActions;
import BaseFrameworkClasses.SingletonBaseDriverReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BaseSeleniumActions {

    By loginButton = By.xpath("//button[contains(text(),'Login')]");

    public Boolean clickOnButton(WebDriver driver){
        try {
            SingletonBaseDriverReports.setTestName("Pressing on login button");
            waitUntilElementIsClickable(driver, loginButton);
        }catch (Exception e){
            SingletonBaseDriverReports.setFailResult("The button was not pressed");
            return false;
        }
        SingletonBaseDriverReports.setPassResult("The button was pressed");
        return true;
    }
}
