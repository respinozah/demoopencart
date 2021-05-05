package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage{

    public DashboardPage(WebDriver driver){
        super(driver);
    }

    public void searchProduct(String product){
        this.setSearchTextBox().sendKeys(product);
        this.setSearchButton().click();
    }

    public WebElement setDashboardAccountContainer(){
        return driver.findElement(By.id("account-account"));
    }

    public WebElement setSearchTextBox(){
        return driver.findElement(By.name("search"));
    }

    public WebElement setSearchButton(){
        return driver.findElement(By.xpath("//*[@type=\"button\" and @class=\"btn btn-default btn-lg\"]"));
    }

    public WebElement setElementResult(String product){
        return driver.findElement(By.xpath("//a[contains(text(),\"" + product + "\")]"));
    }
}