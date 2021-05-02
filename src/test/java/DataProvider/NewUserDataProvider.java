package DataProvider;

import Pojo.RegisterData;
import org.testng.annotations.DataProvider;

public class NewUserDataProvider {

    @DataProvider(name="getNewUserData")
    public Object[][] getNewUserData() throws Exception{
        RegisterData newUser = new RegisterData();
        Object[][] returnValue = new Object[1][5];
        returnValue[0][0] = newUser.getFirstName();
        returnValue[0][1] = newUser.getLastName();
        returnValue[0][2] = newUser.getEmail();
        returnValue[0][3] = newUser.getPhone();
        returnValue[0][4] = newUser.getPassword();
        return returnValue;
    }
}
