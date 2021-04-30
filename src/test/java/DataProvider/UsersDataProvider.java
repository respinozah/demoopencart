package DataProvider;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.testng.annotations.DataProvider;
import Pojo.LoginData;

public class UsersDataProvider {

    @DataProvider(name="getUserDataFromJson")
    public Object[][] getUsersDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = JsonParser.parseReader( new FileReader("src/test/java/DataFiles/UserCredentials.json"));
        JsonElement usersDataSet = jsonData.getAsJsonObject().get("dataset");

        List<LoginData> usersData = new Gson().fromJson(usersDataSet, new TypeToken<List<LoginData>>(){}.getType());

        Object[][] returnValue = new Object[usersData.size()][1];

        int index = 0;

        for(Object[] each: returnValue)  {
            each[0] = usersData.get(index++);
        }

        return returnValue;
    }
}
