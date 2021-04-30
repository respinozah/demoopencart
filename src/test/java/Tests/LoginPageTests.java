package Tests;

import DataProvider.UsersDataProvider;
import PageObjects.DashboardPage;
import PageObjects.LoginPage;
import Pojo.LoginData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest{

    @Test(groups = {"regression", "sanity"}, dataProvider = "getUserDataFromJson", dataProviderClass = UsersDataProvider.class)
    public void doLogin(LoginData _loginData) throws InterruptedException{
        LoginPage login = new LoginPage(driver);
        login.doLogin(_loginData.getEmail(), _loginData.getPassword());

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.waitUntilElementExists(dashboard.setDashboardAccountContainer());
        Assert.assertTrue(dashboard.setDashboardAccountContainer().isDisplayed());
    }
}