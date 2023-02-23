package com.second.service_second_backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest
class ServiceSecondBackendApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void getAndSetThingID(){
		Cart cut = new Cart();
		Long myId = 1L;
		cut.setId(myId);
		assertEquals(myId, cut.getId());
	}


	@Test
	void getName(){
		Cart cut = new Cart();
		String myName = "table";
		cut.setName(myName);
		assertEquals(myName, cut.getName());
	}


	@Test
	void getImage(){
		Cart cut = new Cart();
		String image = "url.com";
		cut.setImage(image);
		assertEquals(image, cut.getImage());
	}
	@Test
	void getQuantity(){
		Cart cut = new Cart();
		String quantity = "#";
		cut.setQuantity(quantity);
		assertEquals(quantity, cut.getQuantity());
	}
	@Test
	void getPrice(){
		Cart cut = new Cart();
		String price = "684,750,000";
		cut.setPrice(price);
		assertEquals(price, cut.getPrice());
	}

	@Test
	void getTotalPrice(){
		Cart cut = new Cart();
		String totalprice = "684,750,000";
		cut.setTotalPrice(totalprice);
		assertEquals(totalprice, cut.getTotalPrice());
	}
}
