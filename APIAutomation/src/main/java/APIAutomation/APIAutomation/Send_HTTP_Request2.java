package APIAutomation.APIAutomation;
import java.text.SimpleDateFormat;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
public class Send_HTTP_Request2 {
	public static void main(String[] args) {
     try {
         Send_HTTP_Request2.call_me();
        } catch (Exception e) {
         e.printStackTrace();
       }
     }
	   
public static void call_me() throws Exception {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String todaysDate = "2019-01-25";
	//System.out.println(sdf.parse(startDate).before(sdf.parse(endDate)));
		JSONObject jsonObject;
		int count = 0;
		int totalPrice = 0;
	try {
	    HttpClient client = new DefaultHttpClient();  
	    String getURL = "https://http-hunt.thoughtworks-labs.net/challenge/input";
	    HttpGet get = new HttpGet(getURL);
	    get.setHeader("Content-Type", "application/json");
	    get.setHeader("userId", "_514A_6Sv");
	    HttpResponse responseGet = client.execute(get);  
	    HttpEntity resEntityGet = responseGet.getEntity();  
	    if (resEntityGet != null) {  
	        //do something with the response
	    	String str = EntityUtils.toString(resEntityGet);
	        JSONArray array = new JSONArray(str);
				// System.out.println(array.toString());
				for (int i = 0; i < array.length(); i++) {
					jsonObject = new JSONObject();
					jsonObject = array.getJSONObject(i);
					// System.out.println(jsonObject.get("endDate"));
					if (sdf.parse((String) jsonObject.get("startDate")).before(sdf.parse(todaysDate))) {

						if (jsonObject.get("endDate").equals(null)) {
							count++;
							totalPrice = totalPrice+(Integer)jsonObject.get("price");
						} else if (sdf.parse(todaysDate).before(sdf.parse((String) jsonObject.get("endDate")))) {
							count++;
							totalPrice = totalPrice+(Integer)jsonObject.get("price");
						}

					}
	        	
	        }
	        System.out.println(count);
	        System.out.println(totalPrice);
	        HttpClient httpClient = HttpClientBuilder.create().build();
	        HttpPost httppost = new HttpPost("https://http-hunt.thoughtworks-labs.net/challenge/output");
//	        String op = "{\"output\": {  \"count\":"+count+"}}";
	        StringEntity params =new StringEntity("{\r\n \"output\": {\r\n  \"totalValue\":"+ totalPrice+"}}");
	        
	        httppost.setHeader("Content-Type", "application/json");
	        httppost.setHeader("userId", "_514A_6Sv");
	        httppost.setEntity(params);
//	        System.out.println(op);
	        HttpResponse response = httpClient.execute(httppost);
	        HttpEntity resEntityGet1 = response.getEntity();
	        String str1 = EntityUtils.toString(resEntityGet1);
	        System.out.println(str1);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	
	
//     String url = "https://http-hunt.thoughtworks-labs.net/challenge/input";
//     URL obj = new URL(url);
//     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//     // optional default is GET
//     con.setRequestMethod("GET");
//     
//     //add request header
//     con.setRequestProperty("User-Agent", "Mozilla/5.0");
//     int responseCode = con.getResponseCode();
//     System.out.println("\nSending 'GET' request to URL : " + url);
//     System.out.println("Response Code : " + responseCode);
//     BufferedReader in = new BufferedReader(
//             new InputStreamReader(con.getInputStream()));
//     String inputLine;
//     StringBuffer response = new StringBuffer();
//     while ((inputLine = in.readLine()) != null) {
//     	response.append(inputLine);
//     }
//     in.close();
//     //print in String
//     System.out.println(response.toString());
//     //Read JSON response and print
//     JSONObject myResponse = new JSONObject(response.toString());
//     System.out.println("result after Reading JSON Response");
//     System.out.println("statusCode- "+myResponse.getString("statusCode"));
//     System.out.println("statusMessage- "+myResponse.getString("statusMessage"));
//     System.out.println("ipAddress- "+myResponse.getString("ipAddress"));
//     System.out.println("countryCode- "+myResponse.getString("countryCode"));
//     System.out.println("countryName- "+myResponse.getString("countryName"));
//     System.out.println("regionName- "+myResponse.getString("regionName"));
//     System.out.println("cityName- "+myResponse.getString("cityName"));
//     System.out.println("zipCode- "+myResponse.getString("zipCode"));
//     System.out.println("latitude- "+myResponse.getString("latitude"));
//     System.out.println("longitude- "+myResponse.getString("longitude"));
//     System.out.println("timeZone- "+myResponse.getString("timeZone"));  
//   }
}
}