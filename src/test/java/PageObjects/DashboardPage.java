package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage{

    public WebElement dashboardContainer;

    public DashboardPage(WebDriver driver){
        super(driver);
    }

    public WebElement getDashboardContainer(){
        return this.dashboardContainer;
    }

    public WebElement setDashboardAccountContainer(){
        return driver.findElement(By.id("account-account"));
    }
}