package Pages;

import BaseFrameworkClasses.BaseSeleniumActions;
import BaseFrameworkClasses.SingletonBaseDriverReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyNotesPage extends BaseSeleniumActions {

    By myNotes = By.xpath("//h2[contains(text(),'My Notes')]");



    public Boolean validation(WebDriver driver){
        try {
            SingletonBaseDriverReports.setTestName("Validating my notes are visible");
            if (getText(driver,myNotes).equals("My Notes")){
                SingletonBaseDriverReports.setPassResult("The my notes are visible");
                return true;
            }else {
                SingletonBaseDriverReports.setFailResult("The my notes was not visible");
                SingletonBaseDriverReports.addingFailedDescriptionsToHashMap("MyNotesPage line 15","The my notes page was not visible");
                return false;
            }
        }catch (Exception e){
            SingletonBaseDriverReports.setFailResult("The my notes was not visible due: "+e);
         return false;
        }
    }

    public void test(){

    }
}
