package me.ywoo.domain;

import java.util.ArrayList;
import java.util.Objects;

public class UserLottoTickets {
    private static final int MINIMUM_TO_COUNT = 0;
    public static ArrayList<RandomNumbers> lottoNumbers = new ArrayList<RandomNumbers>();

    public UserLottoTickets(int countOfLotto) {
        while (countOfLotto-- > MINIMUM_TO_COUNT) {
            this.lottoNumbers.add(new RandomNumbers());
        }
        Objects.requireNonNull(lottoNumbers, "발행된 로또 티켓이 없습니다.");
    }

}
