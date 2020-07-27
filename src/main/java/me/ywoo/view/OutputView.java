package me.ywoo.view;

import me.ywoo.domain.LottoTicket;
import me.ywoo.domain.Rank;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
	public static void printCountOfLotto(int count) {
		System.out.println(count + "개를 구매했습니다.");
	}

	public static void printTickets(List<LottoTicket> UserLotto) {
		for (LottoTicket lottoTicket : UserLotto) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(makeString(lottoTicket));
			System.out.println(stringBuilder);
		}
		System.out.println();
	}

	public static List<String> makeString(LottoTicket lottoTicket) {
		List<String> numbers = new ArrayList<>();
		for (Integer lottoNumbers : lottoTicket.getRandomNumbers()) {
			numbers.add(lottoNumbers.toString());
		}
		return numbers;
	}

	public static void printResult() {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("----------");
	}

	public static void printCountOfSameNumber(Rank rank, Integer counts) {
		System.out.println(
			String.format("%d개 일치 (%d원)- %d개", rank.getCountOfSameNumber(), rank.getPriceOfLotto(), counts));
	}

	public static void printSecondRankCountOfSameNumber(Rank rank, Integer counts) {
		System.out.println(
			String.format("%d개 일치, 보너스 볼 일치 (%d원)- %d개", rank.getCountOfSameNumber(), rank.getPriceOfLotto(), counts));
	}

	public static void printYield(Long yield) {
		System.out.println("총 수익률은 " + yield + "%입니다.");
	}
}
