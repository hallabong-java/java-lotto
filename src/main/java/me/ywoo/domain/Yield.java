package me.ywoo.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class Yield {
	public BigInteger yield;
	public BigInteger totalEarning;

	public BigInteger calculateTotalEarning(ArrayList<RandomNumbers> lottoNumbers, ArrayList<Integer> winnerNumbers,
		int bonusBall, ResultLotto resultLotto) {
		Objects.requireNonNull(lottoNumbers, "가진 티켓이 없습니다.");

		totalEarning = BigInteger.ZERO;
		resultLotto.calculateResult(lottoNumbers, winnerNumbers, bonusBall);
		for (Map.Entry<Rank, Integer> eachRank : resultLotto.getResult().entrySet()) {
			totalEarning = BigInteger.valueOf(eachRank.getValue() * eachRank.getKey().getPriceOfLotto())
				.add(totalEarning);
		}
		return totalEarning;
	}

	public BigInteger calculateYield(BigInteger totalEarning, int price) {
		Objects.requireNonNull(totalEarning, "총 수익이 없습니다.");
		yield = totalEarning.multiply(BigInteger.valueOf(100)).divide(BigInteger.valueOf(price));
		return yield;
	}

	public BigInteger getYield() {
		return yield;
	}
}
