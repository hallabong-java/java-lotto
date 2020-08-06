package me.ywoo.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Yield {
	private ResultLotto resultLotto = new ResultLotto();

	public Long calculateTotal(List<LottoTicket> lottoNumbers, List<Integer> winnerNumbers, int bonusBall) {
		Long totalEarning = Long.valueOf(0);
		Objects.requireNonNull(lottoNumbers, "가진 티켓이 없습니다.");
		Objects.requireNonNull(winnerNumbers, "우승 로또가 없습니다.");

		resultLotto.calculateResult(lottoNumbers, winnerNumbers, bonusBall);
		for (Map.Entry<Rank, Integer> entry : resultLotto.getResult().entrySet()) {
			Long nowEarning = entry.getValue() * entry.getKey().getPriceOfLotto();
			totalEarning = (nowEarning) + (totalEarning);
		}
		return (totalEarning * 100);
	}

	public Map<Rank, Integer> getResultLotto() {
		return resultLotto.getResult();
	}
}
