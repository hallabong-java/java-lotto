package me.ywoo.controller;

import me.ywoo.domain.*;
import me.ywoo.view.InputView;
import me.ywoo.view.OutputView;

import java.util.Map;

public class LottoController {
	public void run() {
		Yield yield = new Yield();
		printResult(buyLotto(yield), yield);
	}

	private Long buyLotto(Yield yield) {
		CountsOfLotto countsOfLottoNumber = new CountsOfLotto(InputView.receivePrice());
		UserLottoTickets userLottoTickets = new UserLottoTickets(countsOfLottoNumber);
		OutputView.printTickets(userLottoTickets);

		WinnerLotto winnerLotto = new WinnerLotto(InputView.receiveWinnerNumbers());
		final Integer bonusBallNumber = new BonusBall(InputView.receiveBonusBallNumber()).getBonusBall();
		if (winnerLotto.searchNumber(bonusBallNumber)) {
			throw new IllegalArgumentException("보너스 볼의 값이 당첨 로또와 일치합니다.");
		}
		return countsOfLottoNumber.dividePrice(
			yield.calculateTotal(userLottoTickets.getLottoNumbers(), winnerLotto.getWinnerNumbers(), bonusBallNumber));
	}

	private void printResult(Long yieldNumber, Yield yield) {
		OutputView.printResult();
		for (Map.Entry<Rank, Integer> entry : yield.getResultLotto().entrySet()) {
			printWhichNumber(entry);
		}
		OutputView.printYield(yieldNumber);
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
