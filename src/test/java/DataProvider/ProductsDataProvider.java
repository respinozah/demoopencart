package DataProvider;

import Pojo.LoginData;
import Pojo.ProductData;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ProductsDataProvider {

    @DataProvider(name="getProductsDataFromJson")
    public Object[][] getProductsDataFromJson() throws FileNotFoundException{
        JsonElement jsonData = JsonParser.parseReader( new FileReader("src/test/java/DataFiles/Products.json"));
        JsonElement productsDataSet = jsonData.getAsJsonObject().get("dataset");

        List<ProductData> productsData = new Gson().fromJson(productsDataSet, new TypeToken<List<ProductData>>(){}.getType());

        Object[][] returnValue = new Object[productsData.size()][1];

        int index = 0;

        for(Object[] each: returnValue)  {
            each[0] = productsData.get(index++);
        }

        return returnValue;
    }
}
