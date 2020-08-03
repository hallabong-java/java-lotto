package me.ywoo.controller;

import me.ywoo.domain.*;
import me.ywoo.view.InputView;
import me.ywoo.view.OutputView;

import java.util.Map;

public class LottoController {
	public void run() {
		buyLotto();
	}

	private void buyLotto() {
		//Price price = new Price(InputView.receivePrice());
		CountsOfLotto countsOfLotto = new CountsOfLotto(InputView.receivePrice());
		OutputView.printCountOfLotto(countsOfLotto.getCount());

		UserLottoTickets userLottoTickets = new UserLottoTickets(countsOfLotto.getCount());
		OutputView.printTickets(userLottoTickets.getLottoNumbers());
		receiveWinner(userLottoTickets, price.getPrice());
	}

	private void receiveWinner(UserLottoTickets userLottoTickets, int price) {
		WinnerLotto winnerLotto = new WinnerLotto(InputView.receiveWinnerNumbers());
		BonusBall bonusBall = new BonusBall(InputView.receiveBonusBallNumber());
		if (winnerLotto.searchNumber(bonusBall.getBonusBall())) {
			bonusBall.duplicationException();
		}
		calculateResult(userLottoTickets, winnerLotto, price, bonusBall.getBonusBall());
	}

	private void calculateResult(UserLottoTickets userLottoTickets, WinnerLotto winnerLotto, int price, int bonusBall) {
		ResultLotto resultLotto = new ResultLotto();
		Yield yield = new Yield();
		yield.calculateYield(userLottoTickets.getLottoNumbers(), winnerLotto.getWinnerNumbers(), bonusBall, resultLotto, price);
		printResult(resultLotto, yield.getYield());
	}

	private void printResult(ResultLotto resultLotto, Long yield) {
		OutputView.printResult();
		for (Map.Entry<Rank, Integer> entry : resultLotto.getResult().entrySet()) {
			printWhichNumber(entry);
		}
		OutputView.printYield(yield);
	}

	private void printWhichNumber(Map.Entry<Rank, Integer> entry) {
		if (!entry.getKey().equals(Rank.SECOND) && !entry.getKey().equals(Rank.NOTHING)) {
			OutputView.printCountOfSameNumber(entry.getKey(), entry.getValue());
		}
		if (entry.getKey().equals(Rank.SECOND)) {
			OutputView.printSecondRankCountOfSameNumber(entry.getKey(), entry.getValue());
		}
	}
}
