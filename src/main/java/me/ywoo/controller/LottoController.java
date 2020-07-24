package me.ywoo.controller;

import me.ywoo.domain.*;
import me.ywoo.view.InputView;
import me.ywoo.view.OutputView;

public class LottoController {
    public void run(){
        Price price = new Price(InputView.receivePrice());
        CountsOfLotto countsOfLotto = new CountsOfLotto(price.getPrice());
        OutputView.printCountOfLotto(countsOfLotto.getCount());

        UserLottoTickets userLottoTickets = new UserLottoTickets(countsOfLotto.getCount());
        OutputView.printTickets(userLottoTickets.getLottoNumbers());

        WinnerLotto winnerLotto = new WinnerLotto(InputView.receiveWinnerNumbers());
        BonusBall bonusBall = new BonusBall(InputView.receiveBonusBallNumber(), winnerLotto.getWinnerNumbers());

        Yield yield = new Yield();
        yield.calculateYield(yield.calculateTotalEarning(userLottoTickets.getLottoNumbers(), winnerLotto.getWinnerNumbers(), bonusBall.getBonusBall()), price.getPrice());
        OutputView.printResult();
        OutputView.printYield(yield.yield);
    }
}
