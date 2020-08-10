package me.ywoo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserLottoTickets {
	private List<LottoTicket> lottoNumbers;

	public UserLottoTickets(CountsOfLotto countOfLotto) {
		lottoNumbers = new ArrayList<>();
		while (countOfLotto.isValid()) {
			lottoNumbers.add(new LottoTicket());
		}
		Objects.requireNonNull(lottoNumbers, "발행된 로또 티켓이 없습니다.");
	}

	public List<Rank> calculateRankOfTicket(WinnerLotto winnerLotto, Integer bonusBall){
		List<Rank> ranks = new ArrayList<>();
		for(LottoTicket lottoTicket : lottoNumbers) {
			int countsOfMatchNumber = lottoTicket.giveCountOfMatchNumber(winnerLotto);
			Rank rank = Rank.valueOf(countsOfMatchNumber, lottoTicket.searchNumber(bonusBall));
			ranks.add(rank);
		}
		return ranks;
	}

	public List<LottoTicket> getLottoNumbers() {
		return lottoNumbers;
	}

	public int getSize() {
		return lottoNumbers.size();
	}
}
