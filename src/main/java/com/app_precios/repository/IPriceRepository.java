package com.app_precios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;
import com.app_precios.model.Price;

public interface IPriceRepository extends JpaRepository<Price, Long>{
	List<Price> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
			int brandId, int productId, LocalDateTime startDate, LocalDateTime endDate);
	
	List<Price> findByBrandIdAndProductId(int brandId, int productId);
}
