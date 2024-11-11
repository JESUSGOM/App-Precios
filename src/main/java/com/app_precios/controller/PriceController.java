package com.app_precios.controller;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app_precios.model.Price;
import com.app_precios.service.PriceService;

@RestController
public class PriceController {
	private final PriceService priceService;
	
	public PriceController(PriceService priceService) {
		this.priceService = priceService;
	}
	
	@GetMapping("/api/prices/{brandId}/{productId}/{iniApplicationDate}/{finApplicationDate}")
    public ResponseEntity<Price> getPrice(
    		@PathVariable int brandId,
    		@PathVariable int productId,
    		@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime iniApplicationDate,
    		@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime finApplicationDate) {
        
        return priceService.findApplicablePrice(brandId, productId, iniApplicationDate, finApplicationDate)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
	
	@GetMapping("/api/prices/{brandId}/{productId}")
    public ResponseEntity<Price> getPriceForBrandAndProduct(
    		@PathVariable int brandId,
    		@PathVariable int productId) {
        
        return priceService.findByBrandAndProduct(brandId, productId)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
	
	
}
