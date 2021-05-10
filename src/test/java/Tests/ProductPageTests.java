package Tests;

import DataProvider.ProductsDataProvider;
import PageObjects.DashboardPage;
import PageObjects.ProductPage;
import PageObjects.ResultsPage;
import Pojo.ProductData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTests extends BaseTest{

    @Test(groups = {"regression", "sanity"}, dataProvider = "getProductsDataFromJson", dataProviderClass = ProductsDataProvider.class)
    public void doVerifyCurrency(ProductData _productData) throws InterruptedException{
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.searchProduct(_productData.getName());
        dashboard.waitUntilElementExists(dashboard.setElementResult(_productData.getName()));

        ResultsPage results = new ResultsPage(driver);
        results.setProductLink(_productData.getName()).click();

        ProductPage productPage = new ProductPage(driver);
        productPage.waitUntilElementExists(productPage.setChangeCurrency());

        productPage.changeCurrency("Euro");
        results.implicitWait(2);
        Assert.assertTrue(productPage.verifyPriceByCurrency(_productData.getPriceEuro(), "Euro"));

        productPage.changeCurrency("Pound");
        results.implicitWait(2);
        Assert.assertTrue(productPage.verifyPriceByCurrency(_productData.getPricePound(), "Pound"));

        productPage.changeCurrency("Dollar");
        results.implicitWait(2);
        Assert.assertTrue(productPage.verifyPriceByCurrency(_productData.getPriceDollar(), "Dollar"));
    }
}
