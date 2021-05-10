package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;
    public String baseURL = "https://demo.opencart.com/index.php?route=account/login";

    @BeforeMethod(alwaysRun = true)
    public void setUpTest(){
        setDrivers("Chrome");
        driver.get(baseURL);
    }

    @AfterMethod(alwaysRun = true)
    public void TearDown(){
        driver.close();
        try{
            driver.quit();
        }
        catch (WebDriverException e){
            System.out.println("Driver session is closed.");
        }
    }

    private void setDrivers(String browser){
        switch (browser){
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
    }
}
