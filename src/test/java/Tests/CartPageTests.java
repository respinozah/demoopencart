package Tests;

import DataProvider.ProductsDataProvider;
import PageObjects.DashboardPage;
import PageObjects.ResultsPage;
import Pojo.ProductData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;

public class CartPageTests extends BaseTest{

    @Test(groups = {"regression", "sanity"}, dataProvider = "getProductsDataFromJson", dataProviderClass = ProductsDataProvider.class)
    public void AddProductToCart(ProductData _productData) throws InterruptedException{
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.searchProduct(_productData.getName());
        dashboard.waitUntilElementExists(dashboard.setElementResult(_productData.getName()));

        ResultsPage results = new ResultsPage(driver);
        results.addToCart();
        results.implicitWait(2);
        Assert.assertTrue(results.setProductAddedToCartAlert().isDisplayed());
    }
}
