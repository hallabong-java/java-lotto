package me.ywoo.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ResultLotto {
    private static final int INITIAL_COUNT = 0;

    public final Map<Rank, Integer> result;

    public ResultLotto() {
        result = new HashMap<>();
        for(Rank rank : Rank.values()){
            result.put(rank, INITIAL_COUNT);
        }
    }

    public Map<Rank, Integer> calculateResult(UserLottoTickets userLottoTickets){
        Objects.requireNonNull(userLottoTickets, "가진 티켓이 없습니다.");
        for(RandomNumbers randomNumbers : userLottoTickets.lottoNumbers){
            Rank rank = Rank.valueOf(randomNumbers.searchMatchNumber(WinnerLotto.winnerNumbers));
            result.put(rank, result.get(rank)+1);
        }
        return result;
    }
}
