package me.ywoo.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class RandomNumberGenerator {
    private static final int UPPER_BOUNDARY = 45;
    private static final int LOWER_BOUNDARY = 0;
    private static final int SIZE_OF_LOTTO = 6;

    public int randomNumber;

    public RandomNumberGenerator() {
        this.randomNumber = new Random().nextInt(UPPER_BOUNDARY) +1;
    }

//    public ArrayList<Integer> generate() {
//        return Arrays.stream(new RandomNumberGenerator().randomNumber)
//                .
//    }

    public List<Integer> generateRandomNumber(){
        return new Random().ints(LOWER_BOUNDARY, UPPER_BOUNDARY+1)
                .distinct()
                .limit(SIZE_OF_LOTTO)
                .boxed()
                .collect(toList());
    }
}
