package Pojo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class RegisterData {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;

    public RegisterData(){
        Calendar calendar = new GregorianCalendar().getInstance();
        Date date = new Date();
        calendar.setTime(date);

        String timeStamp = calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + "_" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE) + "-" + calendar.get(Calendar.SECOND);
        firstName = "user " + timeStamp;
        lastName = "Test";
        email = timeStamp + "@testmail.com";
        phone = "5555555";
        password = "Test123";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() { return phone; }

    public String getPassword() { return password; }
}
