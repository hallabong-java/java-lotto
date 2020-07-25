package me.ywoo.view;

import me.ywoo.domain.RandomNumbers;
import me.ywoo.domain.RandomNumbersGenerator;
import me.ywoo.domain.Rank;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void printCountOfLotto(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printTickets(ArrayList<RandomNumbers> UserLotto) {
        for (RandomNumbers randomNumbers : UserLotto) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(makeString(randomNumbers, stringBuilder));
            System.out.println(stringBuilder);
        }
    }

    public static List<String> makeString(RandomNumbers randomNumbers, StringBuilder stringBuilder) {
        List<String> numbers = new ArrayList<>();
        for(Integer lottoNumbers : randomNumbers.getRandomNumbers()){
            numbers.add(lottoNumbers.toString());
        }
        return numbers;
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

    public static void printSecondRankCountOfSameNumber(Rank rank, Integer counts) {
        System.out.println(String.format("%d개 일치, 보너스 볼 일치 (%d원)- %d개",
                rank.getCountOfSameNumber(), rank.getPriceOfLotto(), counts
        ));
    }

    public static void printYield(BigInteger yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
