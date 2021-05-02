package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage extends BasePage{

    public AccountPage(WebDriver driver){
        super(driver);
    }

    public WebElement setLoggedAccountContainer(){
        return driver.findElement(By.xpath("//a[contains(text(), \"Your Store\")]"));
    }
}
