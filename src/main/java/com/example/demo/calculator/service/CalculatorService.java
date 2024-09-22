package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	public int add(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}

	public int minus(int num1, int num2) {
		int result = num1 - num2;
		return result;
	}

public int multiply(int num1,int num2) {
	int result = num1 * num2;
	return result;
}
public int divide(int num1, int num2) {
	if(num2 == 0) {
		throw new ArithmeticException("0で割ることはできません");
    }
	int result = num1 / num2;
	return result;
	}
	
}