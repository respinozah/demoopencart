package Pojo;

public class LoginData {

    private String email;
    private String password;

    public LoginData(String _email, String _password){
        email = _email;
        password = _password;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }
}
