package me.ywoo.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum RankMaker {
    NOTHING(0, 0, false),
    FIFTH(3, 5000, false),
    FORTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(6, 30000000, true),
    FIRST(6, 2000000000, false);

    private int countOfSameNumber;
    private int priceOfLotto;
    private boolean bonusMatch;

    RankMaker(int countOfSameNumber, int priceOfLotto, boolean bonusMatch) {
        this.countOfSameNumber = countOfSameNumber;
        this.priceOfLotto = priceOfLotto;
        this.bonusMatch = bonusMatch;
    }

    public static RankMaker valueOf(int countOfSameNumber, int priceOfLotto, boolean bonusMatch) {
        if (countOfSameNumber < 3) {
            return NOTHING;
        }
        if (SECOND.matchRank(countOfSameNumber) && SECOND.bonusMatch) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(rankMaker -> rankMaker.matchRank(countOfSameNumber)
                        && rankMaker != SECOND)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("count가 null입니다!"));
    }

    public boolean matchRank(int countOfSameNumber){
        return this.countOfSameNumber == countOfSameNumber;
    }
}
