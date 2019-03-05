package test.api.automation;

import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ValidatableResponse;

public class GoogleApiForGETRequest {

	@Test
	public void tc_001_getMethod_googleApi() {

		ValidatableResponse response = RestAssured.given().param("location", "-33.8670522,151.1957362")
				.param("radius", "1500").param("type", "restaurant").param("keyword", "keyword")
				.param("key", "AIzaSyBcQT24gJ67ZUPB_XENexSUaS-bkmEQ8pU").when()
				.get("https://maps.googleapis.com/maps/api/place/nearbysearch/json").then().statusCode(200);

		System.out.println(response.extract().path("results"));

	}

}
