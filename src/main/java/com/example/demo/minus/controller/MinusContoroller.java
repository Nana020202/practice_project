package com.example.demo.minus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MinusContoroller {
	@GetMapping("minus")
	public String showMinusForm() {
		return "minus.html";
	}

	@GetMapping("result")
	public String resultUser(@RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model) {

		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		return "result.html";
	}

}