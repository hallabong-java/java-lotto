package me.ywoo.domain;

import java.util.ArrayList;

public class UserLotto {
    public ArrayList<Integer> lottoNumbers = new ArrayList<Integer>();

    public UserLotto() {
        this.lottoNumbers = new RandomNumberGenerator().generateRandomNumber();
    }

    public ArrayList<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
