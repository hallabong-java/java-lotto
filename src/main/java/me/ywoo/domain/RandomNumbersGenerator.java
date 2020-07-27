package me.ywoo.domain;

import java.util.List;

public interface RandomNumbersGenerator {
	int UPPER_BOUNDARY = 45;
	int LOWER_BOUNDARY = 1;

	List<Integer> generateRandomNumber();
}
