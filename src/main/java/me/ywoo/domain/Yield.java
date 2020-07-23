package me.ywoo.domain;

import java.math.BigInteger;
import java.util.Map;

public class Yield {
    public BigInteger yield;

    public Yield() {
        this.yield = calculateYield(calculateTotalEarning(), Price.price);
    }

    private BigInteger calculateTotalEarning() {
        BigInteger totalEarning = BigInteger.ZERO;
        for(Map.Entry<Rank, Integer> eachRank : ResultLotto.getResult().entrySet()){ //****************
            totalEarning = BigInteger.valueOf(eachRank.getValue() * eachRank.getKey().getPriceOfLotto()).add(totalEarning);
        }
        return totalEarning;
    }

    private BigInteger calculateYield(BigInteger totalEarning, int price){
        return totalEarning.divide(BigInteger.valueOf(price));
    }
}
