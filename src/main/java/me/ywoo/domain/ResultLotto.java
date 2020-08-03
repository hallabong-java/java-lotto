package me.ywoo.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ResultLotto {
	private static final int INITIAL_COUNT = 0;

	private Map<Rank, Integer> result;

	public ResultLotto() {
		result = new LinkedHashMap<>();
		for (Rank rank : Rank.values()) {
			result.put(rank, INITIAL_COUNT);
		}
	}

	public void calculateResult(List<LottoTicket> lottoNumbers, List<Integer> winnerNumbers, int bonusBall) {
		Objects.requireNonNull(lottoNumbers, "가진 티켓이 없습니다.");
		Objects.requireNonNull(winnerNumbers, "우승 로또가 없습니다.");

		for (LottoTicket lottoTicket : lottoNumbers) {
			int countsOfMatchNumber = lottoTicket.giveCountOfMatchNumber(winnerNumbers);
			Rank rank = Rank.valueOf(countsOfMatchNumber, lottoTicket.searchNumber(bonusBall));
			result.put(rank, result.get(rank) + 1);
		}
	}

	public Map<Rank, Integer> getResult() {
		return result;
	}
}
