package com.apitest;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetMethod {
	
	String domain = "https://www.smarttechqa.com";
	
	@Test
	public void getMethod() {
		
		RestAssured.baseURI=domain;
		
		RequestSpecification req = RestAssured.given();
		Response res = req.request(Method.GET, "/api/products");
		System.out.println(res.prettyPrint());
		
		//Verify the json object contains the items like products
		
		//Assert.assertTrue(res.prettyPrint().contains("products"));
		res.then().assertThat().body(Matchers.containsString("products"));
		
		//Verify the status codes
		
		res.then().assertThat().statusCode(200);
		
		//Verify the content header
		
		res.then().assertThat().contentType(Matchers.containsString("application/json; charset=utf-8"));
		//String expectedHeader = "application/json; charset=utf-8";
		//String actualHeader = res.header("Content-Type");
		//Assert.assertEquals(actualHeader, expectedHeader);
		
		
		//Verify the respose time
		res.then().assertThat().time(Matchers.lessThan(2000L));
		
		
		
		
	}
	
	
	

}
