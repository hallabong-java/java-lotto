package me.ywoo.domain;

public class Price {
    public int price;

    public Price(String priceText){
        this.price = Integer.parseInt(priceText);
        validateNumber(price);
        validatePrice(price);
    }

    private void validatePrice(int price){

    }

    private void validateNumber(int price){

    }
}
