package Pojo;

public class ProductData {

    private String name;
    private String price;
    private String currency;

    public ProductData(String _name, String _price, String _currency){
        name = _name;
        price = _price;
        currency = _currency;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}
