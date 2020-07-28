package me.ywoo.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Yield {
	public Long yield;
	public Long totalEarning;

	public Long calculateYield(List<LottoTicket> lottoNumbers, List<Integer> winnerNumbers, int bonusBall, ResultLotto resultLotto, int price) {
		Objects.requireNonNull(lottoNumbers, "가진 티켓이 없습니다.");
		Objects.requireNonNull(winnerNumbers, "우승 로또가 없습니다.");
		Objects.requireNonNull(price, "가격이 없습니다.");

		resultLotto.calculateResult(lottoNumbers, winnerNumbers, bonusBall);
		for (Map.Entry<Rank, Integer> entry : resultLotto.getResult().entrySet()) {
			Long nowEarning = entry.getValue() * entry.getKey().getPriceOfLotto();
			totalEarning = (nowEarning) + (totalEarning);
		}
		return (totalEarning * 100) / (price);
	}

	public Long getYield() {
		return yield;
	}
}
