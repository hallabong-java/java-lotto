package me.ywoo.view;

import me.ywoo.domain.RandomNumbers;

import java.util.ArrayList;

public class OutputView {
    public static void printCountOfLotto(int count){
        System.out.println(count+"를 구매했습니다.");
    }

    public static void printTickets(ArrayList<RandomNumbers> UserLotto){
        for(RandomNumbers randomNumbers : UserLotto){
            makeString(randomNumbers);
        }
    }

    public static void makeString(RandomNumbers randomNumbers){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(Integer numbers : randomNumbers.randomNumbers){
            stringBuilder.append(String.join(", "));
        }
        stringBuilder.append("]");
    }

}
