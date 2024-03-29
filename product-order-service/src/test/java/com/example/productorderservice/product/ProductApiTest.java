package com.example.productorderservice.product;

import com.example.productorderservice.ApiTest;
import com.example.productorderservice.product.adapter.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductApiTest extends ApiTest {

    @Autowired
    private ProductRepository productRepository;
    private final ProductSteps productSteps = new ProductSteps();

    @Test
    void 상품등록() {
        final var request = productSteps.상품등록요청_생성();

        // API 요청
        final var response = productSteps.상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void 상품조회() {
        ProductSteps.상품등록요청(productSteps.상품등록요청_생성());
        Long productId = 1L;

        // API 요청
        final var response = ProductSteps.상품조회요청(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
    }

    @Test
    void 상품수정() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final Long productId = 1L;

        final var response = ProductSteps.상품수정요청(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(productRepository.findById(1L).get().getName()).isEqualTo("상품 수정");
    }
}
