package me.ywoo.domain;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinnerLotto {
    private static final String DELIMITER = ", ";

    public static ArrayList<Integer> winnerNumbers;

    public WinnerLotto() {
        winnerNumbers = new ArrayList<Integer>();
    }

    public WinnerLotto(final String inputNumbers) {
        findDuplication(createWinnerNumbers(inputNumbers));
    }

    public ArrayList<Integer> createWinnerNumbers(final String inputNumbers) {
        Objects.requireNonNull(inputNumbers, "숫자가 null입니다.");

        for(String numberText : inputNumbers.split(DELIMITER)){
            Integer number = Integer.parseInt(numberText);
            winnerNumbers.add(number);
        }
        return winnerNumbers;
    }

    public void findDuplication(ArrayList<Integer> winnerNumbers){
        if(winnerNumbers.stream().distinct().collect(Collectors.toList()).size() != winnerNumbers.size())
            throw new IllegalArgumentException("값이 중복되지 않게 입력해야 합니다.");
    }
}
