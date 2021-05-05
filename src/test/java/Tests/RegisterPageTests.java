package Tests;

import PageObjects.DashboardPage;
import PageObjects.RegisterPage;
import Pojo.RegisterData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTests extends BaseTest{

    @Test(groups = {"regression", "sanity"})
    public void doRegisterUser(){
        RegisterPage registerPage = new RegisterPage(driver);
        RegisterData newUser = new RegisterData();
        registerPage.waitUntilElementExists(registerPage.getRegisterAccountText());
        registerPage.registerNewUser(newUser.getFirstName(), newUser.getLastName(), newUser.getEmail(), newUser.getPhone(), newUser.getPassword());

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.waitUntilElementExists(dashboard.setDashboardAccountContainer());
        Assert.assertTrue(dashboard.setDashboardAccountContainer().isDisplayed());
    }
}
