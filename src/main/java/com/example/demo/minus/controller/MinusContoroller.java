package com.example.demo.minus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.minus.service.MinusService;

@Controller
public class MinusContoroller {
	private final MinusService minusService;

	public MinusContoroller(MinusService minusService) {
		this.minusService = minusService;

	}
		@GetMapping("minus")
		public String showMinusForm() {
			return "minus.html";
		}

	@GetMapping("result")
	public String resultUser(@RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model) {
		String result = "";
		
		result = String.valueOf(minusService.minus(num1, num2));
		model.addAttribute("result", result);
		System.out.println(result);
		return "minus.html";
	}

}