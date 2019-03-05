package test.twitter.api.automation;

//import static com.jayway.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

//import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
//import com.jayway.restassured.response.Response;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteTweets {
	
	public String ConsumerKey = "O1uqv87kdedU2UVQcMB2ejt5k";
	public String ConsumerSecret = "dm45Sgm0y1sPTD7u3vs7i7cSSCwyCX7WhkZWTWIEduwsgMg5gH";
	public String Token = "1089173373563764737-Pqpon5o6cRb44V2zthc63LK0iON8vQ";
	public String TokenSecret = "fdWzzlh5rGduM9cpxU4jYgMbmKFT8IP1M8uZp5wwNBbdP";
	public String id = "1089776343078719488";

	@Test
	public void E2E() {
//		PostTweets postTweets = new PostTweets();
//		postTweets.createTweet();
		RestAssured.baseURI = "https://api.twitter.com/1.1/statuses";
		Response res = given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).when()
				.post("/destroy/" + id + ".json").then().extract().response();

		String response = res.asString();
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		// System.out.println(js.get("text"));
		System.out.println("Tweet which got deleted with automation is below");
		System.out.println(js.get("text"));
		System.out.println(js.get("truncated"));

	}

}
