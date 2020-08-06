package me.ywoo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserLottoTickets {
	private static final int MINIMUM_TO_COUNT = 0;

	private List<LottoTicket> lottoNumbers;

	public UserLottoTickets(CountsOfLotto countOfLotto) {
		lottoNumbers = new ArrayList<>();
		while (countOfLotto.isValid()) {
			lottoNumbers.add(new LottoTicket());
		}
		Objects.requireNonNull(lottoNumbers, "발행된 로또 티켓이 없습니다.");
	}

	public List<LottoTicket> getLottoNumbers() {
		return lottoNumbers;
	}

	public int size() {
		return lottoNumbers.size();
	}
}
