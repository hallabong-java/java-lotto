package me.ywoo.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ResultLotto {
    private static final int INITIAL_COUNT = 0;

    public Map<Rank, Integer> result;

    public ResultLotto() {
        result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, INITIAL_COUNT);
        }
    }

    public void calculateResult(ArrayList<RandomNumbers> lottoNumbers, ArrayList<Integer> winnerNumbers, int bonusBall) {
        Objects.requireNonNull(lottoNumbers, "가진 티켓이 없습니다.");
        for (RandomNumbers randomNumbers : lottoNumbers) {
            Rank rank = Rank.valueOf(randomNumbers.searchMatchNumber(winnerNumbers),
                    BonusBall.checkHavingBonusBall(randomNumbers.randomNumbers, bonusBall)); //****
            result.put(rank, result.get(rank) + 1);
        }
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }
}
