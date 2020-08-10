package me.ywoo.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ResultLotto {
	private static final int INITIAL_COUNT = 0;
	private static final int ONE_MORE_AT_THIS_RANK = 1;

	private Map<Rank, Integer> result;

	public ResultLotto() {
		this.result = new LinkedHashMap<>();
		for (Rank rank : Rank.values()) {
			result.put(rank, INITIAL_COUNT);
		}
	}

	public void calculateResult(UserLottoTickets lottoNumbers, WinnerLotto winnerNumbers, Integer bonusBall) {
		Objects.requireNonNull(lottoNumbers, "가진 티켓이 없습니다.");
		Objects.requireNonNull(winnerNumbers, "우승 로또가 없습니다.");

		for(Rank rank : lottoNumbers.calculateRankOfTicket(winnerNumbers, bonusBall)){
			result.put(rank, result.get(rank) + ONE_MORE_AT_THIS_RANK);
		}
	}

	public Map<Rank, Integer> getResult() {
		return result;
	}
}
