package BaseFrameworkClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetEnvironment {

    //section to declare global variables
    private Properties properties = new Properties();

    //Section to declare methods

    //This method set the properties locates in the wizeline file
    public Properties initProperties() {

        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + ("/wizeline.properties"));
            properties.load(fileInputStream);
        }
        catch (IOException e){
            System.out.println("Error trying to read properties file: " + e);
        }
        return properties;
    }

    public String getHost(){
        initProperties();
        return properties.getProperty("websiteToOpen");
    }

    public String getUser(){
        initProperties();
        return properties.getProperty("user");
    }

    public String getPassword(){
        initProperties();
        return properties.getProperty("password");
    }
}
