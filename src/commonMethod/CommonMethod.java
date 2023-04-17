package commonMethod;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class CommonMethod {
			
	public static int statusCodeExtrator(String baseURI,String resource,String requestBody)
	{
		RestAssured.baseURI=baseURI;
		int statusCode=given().header("Content-Type", "application/json").body(requestBody)
				.when().put(resource)
				.then().extract().statusCode();
		
		return statusCode;
	}
	
	public static String responseBodyExtrator(String baseURI,String resource,String requestBody)

	{
		String responseBody=given().header("Content-Type","application/json").body(requestBody)
				.when().put(resource)
				.then().extract().response().asString();
		return responseBody;
				
	}
}
