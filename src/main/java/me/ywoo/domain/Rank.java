package me.ywoo.domain;

import java.util.Arrays;

public enum Rank {
    NOTHING(0, 0, false),
    FIFTH(3, 5000, false),
    FORTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(6, 30000000, true),
    FIRST(6, 2000000000, false);

    private static final int minimalToPrize = 3;

    private final int countOfSameNumber;
    private final long priceOfLotto;
    private final boolean bonusMatch;

    Rank(int countOfSameNumber, long priceOfLotto, boolean bonusMatch) {
        this.countOfSameNumber = countOfSameNumber;
        this.priceOfLotto = priceOfLotto;
        this.bonusMatch = bonusMatch;
    }

    public static Rank valueOf(int countOfSameNumber, boolean bonusMatch) {
        if (countOfSameNumber < minimalToPrize) {
            return NOTHING;
        }
        if (SECOND.matchRank(countOfSameNumber) && SECOND.bonusMatch == bonusMatch) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchRank(countOfSameNumber)
                        && rank != SECOND)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("count가 null입니다!"));
    }

    public boolean matchRank(int countOfSameNumber){
        return this.countOfSameNumber == countOfSameNumber;
    }

    public long getPriceOfLotto() {
        return priceOfLotto;
    }

    public int getCountOfSameNumber() {
        return countOfSameNumber;
    }
}
