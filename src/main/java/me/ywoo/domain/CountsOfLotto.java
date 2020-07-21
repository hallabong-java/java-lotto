package me.ywoo.domain;

public class CountsOfLotto {
    private static final int PRICE_UNIT = 1000;
    
    public final int amount;

    public CountsOfLotto(int price) {
        this.amount = price / PRICE_UNIT;
    }
}
