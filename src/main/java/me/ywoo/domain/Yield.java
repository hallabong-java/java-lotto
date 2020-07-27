package me.ywoo.domain;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Yield {
	public Long yield;
	public Long totalEarning;

	public Long calculateTotalEarning(List<RandomNumbers> lottoNumbers, List<Integer> winnerNumbers,
		int bonusBall, ResultLotto resultLotto) {
		Objects.requireNonNull(lottoNumbers, "가진 티켓이 없습니다.");

		resultLotto.calculateResult(lottoNumbers, winnerNumbers, bonusBall);
		for (Map.Entry<Rank, Integer> eachRank : resultLotto.getResult().entrySet()) {
			totalEarning = (eachRank.getValue() * eachRank.getKey().getPriceOfLotto()) + (totalEarning);
		}
		return totalEarning;
	}

	public Long calculateYield(Long totalEarning, int price) {
		Objects.requireNonNull(totalEarning, "총 수익이 없습니다.");

		yield = (totalEarning * 100) / (price);
		return yield;
	}

	public Long getYield() {
		return yield;
	}
}
