	package com.example.demo.calculator.controller;
	
	import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;


	@Controller
	public class CalculatorController {
	
		private final CalculatorService calculatorService;
	
		public CalculatorController(CalculatorService calculatorService) {
			this.calculatorService = calculatorService;
		}
		@GetMapping("calculator") 
		  public String showCalculator() {
		   return "calculator.html";
		  }
		
		 @PostMapping("/calculator")
		public String calculator(
				@RequestParam(name = "num1", required = false) Integer num1,
		        @RequestParam(name = "num2", required = false) Integer num2,
		        @RequestParam("operation") String operation,
		        Model model) {
			if (num1 == null || num2 == null || operation == null) {
	            return "calculator.html";
	        }
			
			String result = "";
	
			switch (operation) {
	        case "add":
	            result = String.valueOf(calculatorService.add(num1, num2));
	            break;
	        case "minus":
	            result = String.valueOf(calculatorService.minus(num1, num2));
	            break;
	        case "multiply":
	            result = String.valueOf(calculatorService.multiply(num1, num2));
	            break;
	        case "divide":
	            try {
	                result = String.valueOf(calculatorService.divide(num1, num2));
	            } catch (ArithmeticException e) {
	                result = "エラー: " + e.getMessage(); // 0で割る場合のエラー処理
	            }
	            break;
	        default:
	            result = "無効な操作です";
	    }
	
	    model.addAttribute("result", result);
	    return "calculator.html"; // 同じページに結果を表示
	}
	}
