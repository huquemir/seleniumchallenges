package com.apitest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostMethod {
	
static String domain = "https://www.smarttechqa.com";

static RequestSpecification req;
static Response res;

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
	
	@Test
	public static void postMethod() {
		//Post Method
		RestAssured.baseURI=domain;
		
		req = RestAssured.given().header("Authorization", getToken());
	/*		
		Map <String, String> data = new LinkedHashMap<>();
		data.put("name", "Sample name");
		data.put("price", "0");
		data.put("description", "Sample description");
		data.put("image", "/images/sample.jpg");
		data.put("brand", "Sample brand");
		data.put("category", "Sample category");
		data.put("countInStock", "0");
		
		JSONObject obj = new JSONObject(data);
		String json = obj.toJSONString();
		req.body(json);
	*/	
		res = req.request(Method.POST, "/api/products");
		

		String item = res.jsonPath().get("_id");	
		System.out.println("The id of the item is : "+item);
		
		
		//System.out.println(res.prettyPrint());
		
		//Verify the json object contains the items like products
		
		//Assert.assertTrue(res.prettyPrint().contains("products"));
		res.then().assertThat().body(Matchers.containsString("name"));
		
		//Verify the status codes
		
		res.then().assertThat().statusCode(201);
		
		//Verify the content header
		
		res.then().assertThat().contentType(Matchers.containsString("application/json; charset=utf-8"));
		//String expectedHeader = "application/json; charset=utf-8";
		//String actualHeader = res.header("Content-Type");
		//Assert.assertEquals(actualHeader, expectedHeader);
		
		
		//Verify the respose time
		res.then().assertThat().time(Matchers.lessThan(2000L));
		
		//Put Method
		
		
		
		Map update = new LinkedHashMap();
		update.put("name", "Television");
		update.put("price", "4000");
		update.put("user", "req.user._id");
		update.put("image", "/images/sample.jpg");
		update.put("brand", "Sample brand");
		update.put("category", "Sample category");
		update.put("countInStock", 1);
		update.put("numReviews", 0);
		update.put("description", "LG television");
		
		
		
		
		
		JSONObject object = new JSONObject(update);
		String jsonBody = object.toJSONString();
		req.body(jsonBody);
			
		req.request(Method.PUT, "/api/products/"+item);
		
		System.out.println(res.prettyPrint());
		
		
	}

}
