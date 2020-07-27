package me.ywoo.domain;

import java.util.ArrayList;
import java.util.Objects;

public class UserLottoTickets {
	private static final int MINIMUM_TO_COUNT = 0;

	private ArrayList<RandomNumbers> lottoNumbers;

	public UserLottoTickets(int countOfLotto) {
		lottoNumbers = new ArrayList<>();
		while (countOfLotto-- > MINIMUM_TO_COUNT) {
			lottoNumbers.add(new RandomNumbers());
		}
		Objects.requireNonNull(lottoNumbers, "발행된 로또 티켓이 없습니다.");
	}

	public ArrayList<RandomNumbers> getLottoNumbers() {
		return lottoNumbers;
	}
}
