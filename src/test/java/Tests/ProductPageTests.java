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

        ProductPage product = new ProductPage(driver);
        product.waitUntilElementExists(product.setChangeCurrency());


        product.changeCurrency("Euro");
        results.implicitWait(2);
        Assert.assertTrue(product.verifyCurrency("Euro"));

        product.changeCurrency("Pound");
        results.implicitWait(2);
        Assert.assertTrue(product.verifyCurrency("Pound"));

        product.changeCurrency("Dollar");
        results.implicitWait(2);
        Assert.assertTrue(product.verifyCurrency("Dollar"));
    }
}
