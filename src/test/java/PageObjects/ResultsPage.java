package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage extends BasePage{

    public ResultsPage(WebDriver driver){
        super(driver);
    }

    public void addToCart(){
        this.setAddToCartButton().click();
    }

    public WebElement setAddToCartButton(){
        return driver.findElement(By.xpath("//div[@class='product-thumb'][1]//button"));
    }

    public WebElement setProductAddedToCartAlertFlag(){
        return driver.findElement(By.xpath("//i[@class=\"fa fa-check-circle\"]"));
    }

    public WebElement setProductAddedToCartAlert(){
        return driver.findElement(By.xpath("//*[contains(text(),\" Success: You have added \")]"));
    }
}
