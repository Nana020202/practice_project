package com.example.demo.fizzBuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {
	public List<String> fizzBuzz() {
		List<String> numbersList = new ArrayList<>();

		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				numbersList.add("FizzBuzz");
			} else if (i % 3 == 0) {
				numbersList.add("Fizz");
			} else if (i % 5 == 0) {
				numbersList.add("Buzz");
			} else {
				numbersList.add(String.valueOf(i));
			}
		}
		return numbersList;
	}
}