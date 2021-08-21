package BaseFrameworkClasses;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.HashMap;

public class SingletonBaseDriverReports {


    //class instance for the singleton structure, initial value in null
    private static SingletonBaseDriverReports instance=null;
    private static ExtentReports reports = new ExtentReports("Reports/TestSuiteReport.html", true);
    private static ExtentTest test;
    public static HashMap<String,String> testFailedDescriptions = new HashMap<String,String>();
    public static WebDriverWait wait;

    //private constructor for the singleton class
    private SingletonBaseDriverReports(){
    }

    /**We declare the singleton instance if this is null*/
    public static SingletonBaseDriverReports getInstance(){
        if (instance==null){
            instance = new SingletonBaseDriverReports();
        }
        return instance;
    }

    //Methods to be used in the classes
    /**This method is to get the driver instance and use it during all the script flow*/
    public static WebDriver getDriver(){
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("chromedriver"));
        return driver;
    }

    //Method to instance the reports
    public ExtentReports getExtentReports (){
        return reports;
    }

    //method to assign name to the tests
    public static void setTestName(String nameOfTest){
        test = reports.startTest(nameOfTest);
    }

    //Method to set PASS result
    public static void setPassResult(String identifier){
        test.log(LogStatus.PASS,identifier);
    }

    //Method to FAIL result
    public static void setFailResult(String identifier){
        test.log(LogStatus.FAIL,identifier);
    }

    public static void setErrorResult(String identifier){
        test.log(LogStatus.ERROR,identifier);
    }

    public static  void setInfoResult(String identifier){
        test.log(LogStatus.INFO,identifier);
    }


    //This method is to add all the failed scripts in combination with assertions to make an easy debbug.
    public static void addingFailedDescriptionsToHashMap(String keyToIdentifyFollowingClassLineCode,String errorDescription){
        try{
            testFailedDescriptions.put(keyToIdentifyFollowingClassLineCode,errorDescription);
        }catch (Exception e){
            System.out.println("The failed description was not added due: "+e);
        }
    }

    //This method is to print all the failed assertions
    public void printFailedTestCasesDescriptions(){
        if (!testFailedDescriptions.isEmpty()) {
            testFailedDescriptions.forEach((key, value) -> System.out.println(key + ":" + value));
        }else {
            System.out.println("The test/tests is/are finished without failed tests....");
        }
    }

    //This method is to use the wait during all the flow
    public WebDriverWait getWait(WebDriver driver){
        wait = new WebDriverWait(driver,120);
        return wait;
    }

    //Method to end the test and generate the report
    public void endTest() throws IOException {
        reports.endTest(test);
        reports.flush();
    }
}

