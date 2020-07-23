package me.ywoo.domain;

import java.util.ArrayList;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class RandomNumbersGenerator {
    public static final int UPPER_BOUNDARY = 45;
    public static final int LOWER_BOUNDARY = 1;
    private static final int SIZE_OF_LOTTO = 6;

    public ArrayList<Integer> randomNumbers = new ArrayList<>();

    public RandomNumbersGenerator() {
        this.randomNumbers = generateRandomNumber();
                //new Random().nextInt(UPPER_BOUNDARY) +1;
    }

//    public ArrayList<Integer> generate() {
//        return Arrays.stream(new RandomNumbersGenerator().randomNumber)
//                .
//    }

    public ArrayList<Integer> generateRandomNumber(){
        return (ArrayList<Integer>) new Random().ints(LOWER_BOUNDARY-1, UPPER_BOUNDARY+1)
                .distinct()
                .limit(SIZE_OF_LOTTO)
                .boxed()
                .collect(toList());
    }
}
