package com.trycloud.utilities;

/*
    This class will return a single driver object, regardless of the number of times it is called
    This class employs the Singleton pattern
*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.trycloud.utilities.ConfigReader.readProperty;


public class Driver {
    private static WebDriver obj;

    private Driver() {}

    /**
     Return object with only one WebDriver instance
     Will return the same object if it already exists. It will only create a new one if it is null
     */
    public static WebDriver getDriver() {



        String browser = readProperty("browser");

        if (obj == null) {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    obj = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    obj = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    obj = new EdgeDriver();
                    break;
                default:
                    System.err.println("INVALID BROWSER");
            }
        }

        return obj;



    }

    /**
     Quitting the browser and resetting the value of WebDriver instance to null to be able to reuse already quit driver
     */
    public static void closeBrowser() {
        /**
         1. Check if there is a driver instance or not i.e. check whether the obj is null or not
         2. if obj isn't null, quit browser & make it null
         ** Once quit, the driver cannot be used again
         */
        if (obj != null) {
            obj.quit();
            obj = null;
        }
    }


}
