package Pages;

import BaseFrameworkClasses.BaseSeleniumActions;
import BaseFrameworkClasses.GetEnvironment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseSeleniumActions {
    GetEnvironment getEnvironment = new GetEnvironment();

    By user = By.xpath("//input[@placeholder='Username']");
    By password = By.xpath("//input[@placeholder='Password']");
    By button = By.xpath("//button[contains(text(),'Login')]");

    public LoginPage loginPage(WebDriver driver){
        try {
            sendKeys(driver, user, getEnvironment.getUser());
            sendKeys(driver, password, getEnvironment.getPassword());
            waitUntilElementIsClickable(driver, button);
        }catch (Exception e){
            System.out.println("Exception: "+e);
        }
        return new LoginPage();
    }
}
