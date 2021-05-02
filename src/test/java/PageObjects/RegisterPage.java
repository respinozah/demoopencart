package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage{

    public RegisterPage(WebDriver driver){
        super(driver);
        driver.get("https://demo.opencart.com/index.php?route=account/register");
    }

    private WebElement setFirstName(){
        return driver.findElement(By.id("input-firstname"));
    }

    private WebElement setLastName(){
        return driver.findElement(By.id("input-lastname"));
    }

    private WebElement setEmail(){
        return driver.findElement(By.id("input-email"));
    }

    private WebElement setPhone(){
        return driver.findElement(By.id("input-telephone"));
    }

    private WebElement setPassword(){
        return driver.findElement(By.id("input-password"));
    }

    private WebElement setConfirmPassword(){
        return driver.findElement(By.id("input-confirm"));
    }

    private WebElement setAgreement(){return driver.findElement(By.xpath("//*[@name=\"agree\"]"));}

    private WebElement setContinueButton(){return driver.findElement(By.xpath("//*[@type=\"submit\"]"));}

    private WebElement setSecondContinueButton(){return driver.findElement(By.xpath("//a[contains(text(),\"Continue\")]"));}

    public void registerNewUser(String firstName, String lastName, String email, String phone, String password) {
        this.setFirstName().sendKeys(firstName);
        this.setLastName().sendKeys(lastName);
        this.setEmail().sendKeys(email);
        this.setPhone().sendKeys(phone);
        this.setPassword().sendKeys(password);
        this.setConfirmPassword().sendKeys(password);
        this.setAgreement().click();
        this.setContinueButton().click();
        super.waitUntilElementExists(this.getRegisteredAccountText());
        this.setSecondContinueButton().click();
    }

    public WebElement getRegisterAccountText() {
        return driver.findElement(By.xpath("//div/*[contains(text(),\"Register Account\")]"));
    }

    public WebElement getRegisteredAccountText() {
        return driver.findElement(By.xpath("//h1[contains(text(),\"Your Account Has Been Created!\")]"));
    }
}
