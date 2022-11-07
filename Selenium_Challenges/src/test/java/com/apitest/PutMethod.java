package com.apitest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutMethod {
	
	@Test
	public void putMethod() {
		
		RequestSpecification req = RestAssured.given().header("Authorization", PostMethod.getToken());
		
		
		
	}
	

}
