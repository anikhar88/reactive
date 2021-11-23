package com.anxistars.orderservice;

import com.anxistars.orderservice.client.ProductClient;
import com.anxistars.orderservice.client.UserClient;
import com.anxistars.orderservice.dto.ProductDto;
import com.anxistars.orderservice.dto.PurchaseOrderRequestDto;
import com.anxistars.orderservice.dto.PurchaseOrderResponseDto;
import com.anxistars.orderservice.dto.UserDto;
import com.anxistars.orderservice.service.OrderFulfillmentService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class OrderServiceApplicationTests {

	@Autowired
	private ProductClient productClient;

	@Autowired
	private UserClient userClient;

	@Autowired
	private OrderFulfillmentService orderFulfillmentService;

	@Test
	void contextLoads() {
		Flux<PurchaseOrderResponseDto> response =  Flux.zip(this.userClient.getAllUser(), this.productClient.getAllProduct())
				.map(t -> buildDto(t.getT1(), t.getT2()))
				.flatMap(dto -> this.orderFulfillmentService.processOrder(Mono.just(dto)))
				.doOnNext(System.out::println);

		StepVerifier.create(response)
				.expectNextCount(4)
				.expectComplete();
	}

	private PurchaseOrderRequestDto buildDto(UserDto userDto, ProductDto productDto) {
		PurchaseOrderRequestDto dto = new PurchaseOrderRequestDto();
		dto.setUserId(userDto.getId());
		dto.setProductId(productDto.getId());
		return dto;
	}

}
