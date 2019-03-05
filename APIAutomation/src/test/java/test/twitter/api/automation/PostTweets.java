package test.twitter.api.automation;

//import static com.jayway.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

//import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
//import com.jayway.restassured.response.Response;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostTweets {

	public String ConsumerKey = "O1uqv87kdedU2UVQcMB2ejt5k";
	public String ConsumerSecret = "dm45Sgm0y1sPTD7u3vs7i7cSSCwyCX7WhkZWTWIEduwsgMg5gH";
	public String Token = "1089173373563764737-Pqpon5o6cRb44V2zthc63LK0iON8vQ";
	public String TokenSecret = "fdWzzlh5rGduM9cpxU4jYgMbmKFT8IP1M8uZp5wwNBbdP";
	public static String id;

	@Test
	public void createTweet() {

		RestAssured.baseURI= "https://api.twitter.com/1.1/statuses";
		Response res = given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret)
				.queryParam("status", "I am creating this tweet with Automation").when().post("/update.json").then()
				.extract().response();

		String response = res.asString();
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		System.out.println("Below is the tweet added");
		// System.out.println(js.get("text"));
		System.out.println(js.get("id"));
		id = js.get("id").toString();

	}

}
