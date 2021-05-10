package Pojo;

public class ProductData {

    private String name;
    private String priceDollar;
    private String priceEuro;
    private String pricePound;

    public ProductData(String _name, String _priceDollar, String _priceEuro, String _pricePound){
        name = _name;
        priceDollar = _priceDollar;
        priceEuro = _priceEuro;
        pricePound = _pricePound;
    }

    public String getName() {
        return name;
    }

    public String getPriceDollar() {
        return priceDollar;
    }

    public String getPriceEuro() {
        return priceEuro;
    }

    public String getPricePound() {
        return pricePound;
    }
}
