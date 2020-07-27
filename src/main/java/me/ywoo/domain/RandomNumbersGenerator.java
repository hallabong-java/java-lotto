package me.ywoo.domain;

import java.util.ArrayList;

public interface RandomNumbersGenerator {
	int UPPER_BOUNDARY = 45;
	int LOWER_BOUNDARY = 1;

	ArrayList<Integer> generateRandomNumber();
}
