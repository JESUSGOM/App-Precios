package com.app_precios;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AppPreciosApplicationTests {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	void contextLoads() {
	}
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Test
    public void test1_PriceAt14June10am() throws Exception {
        mockMvc.perform(get("/api/prices")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("applicationDate", LocalDateTime.of(2020, 6, 14, 10, 0).format(formatter)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value("35455"))
                .andExpect(jsonPath("$.brandId").value("1"))
                .andExpect(jsonPath("$.priceList").value("1"))
                .andExpect(jsonPath("$.price").value("35.50"))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }

    @Test
    public void test2_PriceAt14June4pm() throws Exception {
        mockMvc.perform(get("/api/prices")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("applicationDate", LocalDateTime.of(2020, 6, 14, 16, 0).format(formatter)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value("35455"))
                .andExpect(jsonPath("$.brandId").value("1"))
                .andExpect(jsonPath("$.priceList").value("2"))
                .andExpect(jsonPath("$.price").value("25.45"))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }

    @Test
    public void test3_PriceAt14June9pm() throws Exception {
        mockMvc.perform(get("/api/prices")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("applicationDate", LocalDateTime.of(2020, 6, 14, 21, 0).format(formatter)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value("35455"))
                .andExpect(jsonPath("$.brandId").value("1"))
                .andExpect(jsonPath("$.priceList").value("1"))
                .andExpect(jsonPath("$.price").value("35.50"))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }

    @Test
    public void test4_PriceAt15June10am() throws Exception {
        mockMvc.perform(get("/api/prices")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("applicationDate", LocalDateTime.of(2020, 6, 15, 10, 0).format(formatter)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value("35455"))
                .andExpect(jsonPath("$.brandId").value("1"))
                .andExpect(jsonPath("$.priceList").value("3"))
                .andExpect(jsonPath("$.price").value("30.50"))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }

    @Test
    public void test5_PriceAt16June9pm() throws Exception {
        mockMvc.perform(get("/api/prices")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("applicationDate", LocalDateTime.of(2020, 6, 16, 21, 0).format(formatter)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value("35455"))
                .andExpect(jsonPath("$.brandId").value("1"))
                .andExpect(jsonPath("$.priceList").value("4"))
                .andExpect(jsonPath("$.price").value("38.95"))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }
}
