package BaseFrameworkClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class BaseSeleniumActions {

    public void waitUntilElementIsClickable(WebDriver driver, By locator){
        try{
           WebElement element= SingletonBaseDriverReports.getInstance().getWait(driver).until(ExpectedConditions.elementToBeClickable(locator));
           element.click();
        }catch (Exception e){

        }
    }

    public void openBrowser(WebDriver driver, String urlToTest){
        driver.get(urlToTest);
        driver.manage().timeouts().pageLoadTimeout(18, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void sendKeys(WebDriver driver, By locator, String textTosend){
        WebElement element = driver.findElement(locator);
        SingletonBaseDriverReports.getInstance().getWait(driver).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(textTosend);
    }

    public void simpleClick(WebDriver driver, By locator){
        driver.findElement(locator).click();
    }

    public String getText(WebDriver driver, By locator){
        WebElement element =driver.findElement(locator);
        SingletonBaseDriverReports.getInstance().getWait(driver).until(ExpectedConditions.visibilityOf(element));
        String value =element.getText();
        return value;
    }
}
