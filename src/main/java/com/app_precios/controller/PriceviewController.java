package com.app_precios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app_precios.model.Price;
import com.app_precios.service.PriceService;

@Controller
public class PriceviewController {
	private PriceService priceService;

	 @Autowired
	    public void PriceViewController(PriceService priceService) {
	        this.priceService = priceService;
	    }
	
	@GetMapping("/")
	public String getPriceView(Model model) 
	{
		List<Price> prices = priceService.findAll();
		model.addAttribute("prices", prices);
		return "priceview";
	}
	
}
