package me.ywoo.controller;

import me.ywoo.domain.*;
import me.ywoo.view.InputView;
import me.ywoo.view.OutputView;

import java.math.BigInteger;
import java.util.Map;

public class LottoController {
	public void run() {
		buyLotto();
	}

	private void buyLotto() {
		Price price = new Price(InputView.receivePrice());
		CountsOfLotto countsOfLotto = new CountsOfLotto(price.getPrice());
		OutputView.printCountOfLotto(countsOfLotto.getCount());
		UserLottoTickets userLottoTickets = new UserLottoTickets(countsOfLotto.getCount());
		OutputView.printTickets(userLottoTickets.getLottoNumbers());
		calculateResult(userLottoTickets, price.getPrice());
		OutputView.printOneLine();
	}

	private void calculateResult(UserLottoTickets userLottoTickets, int price) {
		WinnerLotto winnerLotto = new WinnerLotto(InputView.receiveWinnerNumbers());
		BonusBall bonusBall = new BonusBall(InputView.receiveBonusBallNumber(), winnerLotto.getWinnerNumbers());
		ResultLotto resultLotto = new ResultLotto();
		Yield yield = new Yield();
		yield.calculateYield(
			yield.calculateTotalEarning(userLottoTickets.getLottoNumbers(), winnerLotto.getWinnerNumbers(),
				bonusBall.getBonusBall(), resultLotto), price);
		printResult(resultLotto, yield.getYield());
		OutputView.printOneLine();
	}

	private void printResult(ResultLotto resultLotto, BigInteger yield) {
		OutputView.printResult();
		for (Map.Entry<Rank, Integer> entry : resultLotto.getResult().entrySet()) {
			if (!entry.getKey().equals(Rank.SECOND) && !entry.getKey().equals(Rank.NOTHING)) {
				OutputView.printCountOfSameNumber(entry.getKey(), entry.getValue());
			}
			if (entry.getKey().equals(Rank.SECOND)) {
				OutputView.printSecondRankCountOfSameNumber(entry.getKey(), entry.getValue());
			}

		}
		OutputView.printYield(yield);
	}
}
