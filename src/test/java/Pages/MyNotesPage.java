package Pages;

import BaseFrameworkClasses.BaseSeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyNotesPage extends BaseSeleniumActions {

    By myNotes = By.xpath("//h2[contains(text(),'My Notes')]");

    public Boolean validation(WebDriver driver){
        try {
            if (getText(driver,myNotes).equals("My Notes")){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
         return false;
        }
    }
}
