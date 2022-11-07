package com.base;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiBaseClass {
	
	public static String domain ="https://www.smarttechqa.com";
	public static RequestSpecification req;
	public static Response res;
	
	
	public static String getToken() {
		
		
		Map <String, String> data = new LinkedHashMap<>();
		data.put("email", "apiuser@email.com");
		data.put("password", "api123");
		
		JSONObject obj = new JSONObject(data);
		String json = obj.toJSONString();
		
		RestAssured.baseURI=domain;
		String token = RestAssured.given().contentType("application/json; charset=utf-8")
				.body(json).request(Method.POST, "/api/users/login").jsonPath().get("token");
		return "Bearer "+token;
		
	}
	
	
	public static void apiSetUp(String method, String path) {
		res = null;
		RestAssured.baseURI=domain;	
		req = RestAssured.given().header("Authorization", getToken());
		req.header("content-type", "application/json; charset=utf-8");
		
		if (method.equalsIgnoreCase("get")) {				
		res = req.request(Method.GET, path);
		} else if (method.equalsIgnoreCase("post")) {
		res = req.request(Method.POST, path);	
		} else if (method.equalsIgnoreCase("put")) {			
		res = req.request(Method.PUT, path);
		} else if (method.equalsIgnoreCase("patch")) {
		res = req.request(Method.PATCH, path);	
		} else if (method.equalsIgnoreCase("delete")) {			
		res = req.request(Method.DELETE, path);
		} 	
			
		
		}
	
	
	

}
