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
public class DemoPracticeApi {
	public static void main(String[] args) {
     try {
         DemoPracticeApi.call_me();
        } catch (Exception e) {
         e.printStackTrace();
       }
     }
	   
public static void call_me() throws Exception {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String todaysDate = "2019-01-25";
	//System.out.println(sdf.parse(startDate).before(sdf.parse(endDate)));
		JSONObject jsonObject;
		JSONObject jsonObject2 = new JSONObject();
		int count = 0;
		int kitchencount = 0;
		int furniturecount = 0;
		int electronicscount = 0;
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
							if(jsonObject.get("category").equals("Kitchen"))
								kitchencount++;
							if(jsonObject.get("category").equals("Furniture"))
								furniturecount++;
							if(jsonObject.get("category").equals("Electronics"))
								electronicscount++;
						} else if (sdf.parse(todaysDate).before(sdf.parse((String) jsonObject.get("endDate")))) {
							if(jsonObject.get("category").equals("Kitchen"))
								kitchencount++;
							if(jsonObject.get("category").equals("Furniture"))
								furniturecount++;
							if(jsonObject.get("category").equals("Electronics"))
								electronicscount++;
						}

					}
	        	
	        }
				String op = "{\"output\": {  \"Kitchen\":"+kitchencount+"}}";
				if (kitchencount > 0 && furniturecount==0 && electronicscount==0)
					op = "{\"output\": {  \"Kitchen\":" + kitchencount + "}}";
				else if (kitchencount > 0 && furniturecount > 0 && electronicscount==0)
					op = "{\"output\": {  \"Kitchen\":" + kitchencount + ",\"Furniture\":" + furniturecount + "}}";
				else if (kitchencount > 0 && electronicscount > 0 && furniturecount==0)
					op = "{\"output\": {  \"Kitchen\":" + kitchencount + ",\"Electronics\":" + electronicscount + "}}";
				else if (kitchencount > 0 && electronicscount > 0 && furniturecount > 0)
					op = "{\"output\": {  \"Kitchen\":" + kitchencount + ",\"Furniture\":" + furniturecount
							+ ",\"Electronics\":" + electronicscount + "}}";
				else if (furniturecount > 0 && electronicscount==0 && kitchencount==0)
					op = "{\"output\": {  \"Furniture\":" + furniturecount + "}}";
				else if (electronicscount > 0 && furniturecount > 0 && kitchencount==0)
					op = "{\"output\": { \"Furniture\":" + furniturecount + ",\"Electronics\":" + electronicscount
							+ "}}";
				else if (electronicscount > 0 && furniturecount==0 && kitchencount==0)
					op = "{\"output\": {  \"Electronics\":" + electronicscount + "}}";
	        System.out.println(kitchencount+""+furniturecount+""+electronicscount);
	        HttpClient httpClient = HttpClientBuilder.create().build();
	        HttpPost httppost = new HttpPost("https://http-hunt.thoughtworks-labs.net/challenge/output");
	        
	//        StringEntity params =new StringEntity("{\r\n \"output\": {\r\n  \"Kitchen\":"+ kitchencount+"}}");
	        StringEntity params =new StringEntity(op);
	        httppost.setHeader("Content-Type", "application/json");
	        httppost.setHeader("userId", "_514A_6Sv");
	        httppost.setEntity(params);
	     //   System.out.println(op);
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