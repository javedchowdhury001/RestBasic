package Practise;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class CustomerIndormation {

	
	@Test(priority=1)
	public void testSingleContent() {
		System.out.println("********************* Get Information ***************************");
		given()
		.when().get("http://thomas-bayer.com/sqlrest/CUSTOMER/6")
		.then().body("Customer.ID",equalTo("6")).log().all();
		
		
	}	
	
	@Test(priority=2)
	public void testMultipleContent() {
		System.out.println("********************* Get Information ***************************");
		given()
		.when().get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
		.body("Customer.ID",equalTo("15"))
		.body("Customer.FIRSTNAME",equalTo("Bill"))
		.body("Customer.LASTNAME",equalTo("Clancy"))
		.body("Customer.STREET",equalTo("319 Upland Pl."))
		.body("Customer.CITY",equalTo("Seattle"))
		.log().all();	
	}
	
	@Test(priority=3)
	public void testusingXpath() {
		System.out.println("********************* Get Information ***************************");
		given()
		.when().get("http://thomas-bayer.com/sqlrest/CUSTOMER/40")
		.then().body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Susanne"))).log().all();
	}
	
	@Test(priority=4)
	public void testXpath() {
		System.out.println("********************* Get Information ***************************");
		given()
		.when().get("http://thomas-bayer.com/sqlrest/INVOICE")
		.then().body(hasXPath("/INVOICEList/INVOICE[text()='30']")).log().all();
	}
}
