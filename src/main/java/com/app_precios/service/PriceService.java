package com.app_precios.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app_precios.model.Price;
import com.app_precios.repository.IPriceRepository;

@Service
public class PriceService {
	private final IPriceRepository priceRepository;
	
	public PriceService(IPriceRepository priceRepository) {
		this.priceRepository = priceRepository;
	}
	
	public Optional<Price> findApplicablePrice(int brandId, int productId, LocalDateTime iniApplicationDate, LocalDateTime finApplicationDate) {
        return priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            brandId, productId, iniApplicationDate, finApplicationDate).stream().findFirst();
    }
	
	public Optional<Price> findByBrandAndProduct(int brandId, int productId) {
        return priceRepository.findByBrandIdAndProductId(brandId, productId).stream().findFirst();
    }
	
	public List<Price> findAll() {
        return priceRepository.findAll();
    }

}
