package me.ywoo.domain;

import java.util.ArrayList;
import java.util.Objects;

public class UserLottoTickets {
    public ArrayList<RandomNumbersGenerator> lottoNumbers = new ArrayList<RandomNumbersGenerator>();

    public UserLottoTickets(int countOfLotto) {
        while(countOfLotto-->0){
            this.lottoNumbers.add(new RandomNumbersGenerator());
        }
        Objects.requireNonNull(lottoNumbers, "발행된 로또 티켓이 없습니다.");
    }
}
