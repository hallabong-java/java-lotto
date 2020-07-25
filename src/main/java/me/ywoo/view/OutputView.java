package me.ywoo.view;

import me.ywoo.domain.RandomNumbers;
import me.ywoo.domain.RandomNumbersGenerator;
import me.ywoo.domain.Rank;

import java.math.BigInteger;
import java.util.ArrayList;

public class OutputView {
    public static void printCountOfLotto(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printTickets(ArrayList<RandomNumbers> UserLotto) {
        for (RandomNumbers randomNumbers : UserLotto) {
            makeString(randomNumbers);
        }
    }

    public static void makeString(RandomNumbers randomNumbers) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (Integer numbers : randomNumbers.randomNumbers) {
            stringBuilder.append(String.join(", "));
        }
        stringBuilder.append("]");
    }

    public static void printResult() {
        System.out.println("당첨 통계");
        System.out.println("----------");
    }

    public static void printCountOfSameNumber(Rank rank, Integer counts) {
        System.out.println(String.format("%d개 일치 (%d원)- %d개",
                rank.getCountOfSameNumber(), rank.getPriceOfLotto(), counts
        ));
    }

    public static void printYield(BigInteger yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
