package org.zunzunwang.rest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello twitter");
		OAuthService service = new ServiceBuilder().provider(TwitterApi.SSL.class)
                .apiKey("t7O0kKPpvQTZZFZ4uzXX8b2bl")
                .apiSecret("JSQQq3f7W4aIbJ9MFFFKqdE7Oxb5g4EAR3fiXN53x2DYdYa98F").build();
		Token requestToken = service.getRequestToken();
		Token accessToken= new Token("1917663240-pKhAyGEHswhxXDI557I42jw2xFCQWHyovxUCrii", "7pQ0rgnZWgmu2qjPNhXlaQHboHqCeq7oDqjOnwKYvlfWR");
		
		OAuthRequest request =
				new OAuthRequest(Verb.GET, "https://api.twitter.com/1.1/account/verify_credentials.json");
		service.signRequest(accessToken, request);
		Response response = request.send();
		//question1
		System.out.println(response.getBody());
		JSONParser parser = new JSONParser();
		try {
			Object objetNormal = parser.parse(response.getBody());
			System.out.println(objetNormal);
			
			JSONObject jsonObject = (JSONObject)objetNormal;
			System.out.println("id_str="+jsonObject.get("id_str"));
			System.out.println("name="+jsonObject.get("name"));
			System.out.println("screen_name="+jsonObject.get("screen_name"));
			System.out.println("followers_count="+jsonObject.get("followers_count"));
			System.out.println("friends_count="+jsonObject.get("friends_count"));
			System.out.println("created_at="+jsonObject.get("created_at"));
			System.out.println("time_ zone="+jsonObject.get("time_ zone"));						
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//question2
		OAuthRequest requestfriend =
				new OAuthRequest(Verb.GET, "https://api.twitter.com/1.1/friends/list.json");
		service.signRequest(accessToken, requestfriend);
		Response responsefriend = requestfriend.send();
		System.out.println(responsefriend.getBody());
		JSONParser parserfriend = new JSONParser();
		try {
			Object objetNormalfriend = parserfriend.parse(responsefriend.getBody());
			JSONObject jsonObjectfriend = (JSONObject)objetNormalfriend;
			JSONArray arrayfriend = (JSONArray) jsonObjectfriend.get("users");
			for (int i = 0; i < arrayfriend.size(); i++) {
				System.out.println("_________________________________________");

			
			JSONObject arrayObject = (JSONObject)arrayfriend.get(i);
			System.out.println("name="+arrayObject.get("name"));
			System.out.println("screen_name="+arrayObject.get("screen_name"));
			System.out.println("followers_count="+arrayObject.get("followers_count"));
			System.out.println("friends_count="+arrayObject.get("friends_count"));
			System.out.println("created_at="+arrayObject.get("created_at"));
			System.out.println("time_zone="+arrayObject.get("time_zone"));

			}		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//question3
		OAuthRequest requestfriend3 =
				new OAuthRequest(Verb.GET, "https://api.twitter.com/1.1/friends/list.json");
		service.signRequest(accessToken, requestfriend3);
		Response responsefriend3 = requestfriend3.send();
		System.out.println(responsefriend3.getBody());
		JSONParser parserfriend3 = new JSONParser();
		try {
			Object objetNormalfriend3 = parserfriend3.parse(responsefriend3.getBody());
			JSONObject jsonObjectfriend3 = (JSONObject)objetNormalfriend3;
			JSONArray arrayfriend3 = (JSONArray) jsonObjectfriend3.get("users");
			int count=0;
			for (int i = 0; i < arrayfriend3.size(); i++) {
				System.out.println("_________________________________________");		
			JSONObject arrayObject3 = (JSONObject)arrayfriend3.get(i);
			System.out.println("name="+arrayObject3.get("name"));
			System.out.println("followers_count="+arrayObject3.get("followers_count"));
			}		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}
