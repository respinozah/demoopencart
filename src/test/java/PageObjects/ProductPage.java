package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver){
        super(driver);
    }

    public void changeCurrency(String currency){
        setChangeCurrency().click();
        switch (currency){
            case "Euro":
                setChangeToEuro().click();
                break;
            case "Pound":
                setChangeToPund().click();
                break;
            case "Dollar":
                setChangeToDollar().click();
                break;
        }
    }

    public boolean verifyCurrency(String currency){
        boolean result = false;

        if(currency.equals("Euro") && setPriceInEuro().isDisplayed()){
            result = true;
        }
        else if(currency.equals("Pound") && setPriceInPound().isDisplayed()){
            result = true;
        }
        else if(currency.equals("Dollar") && setPriceInDollar().isDisplayed()){
            result = true;
        }
        return result;
    }

    public WebElement setChangeCurrency(){
        return driver.findElement(By.xpath("//button[@class=\"btn btn-link dropdown-toggle\"]"));
    }

    private WebElement setChangeToEuro(){
        return driver.findElement(By.xpath("//button[@class=\"currency-select btn btn-link btn-block\" and contains(text(),\"Euro\")]"));
    }

    private WebElement setChangeToPund(){
        return driver.findElement(By.xpath("//button[@class=\"currency-select btn btn-link btn-block\" and contains(text(),\"Pound\")]"));
    }

    private WebElement setChangeToDollar(){
        return driver.findElement(By.xpath("//button[@class=\"currency-select btn btn-link btn-block\" and contains(text(),\"Dollar\")]"));
    }

    private WebElement setPriceInEuro(){
        return driver.findElement(By.xpath("//h2[contains(text(),\"€\")]"));
    }

    private WebElement setPriceInPound(){
        return driver.findElement(By.xpath("//h2[contains(text(),\"£\")]"));
    }

    private WebElement setPriceInDollar(){
        return driver.findElement(By.xpath("//h2[contains(text(),\"$\")]"));
    }
}
