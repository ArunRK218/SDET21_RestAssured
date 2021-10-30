package ParameterAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class BarearToken {
	
	@Test
	public void bearerToken() {
		
		HashMap map = new HashMap();
		map.put("name", "REST-SDET21-BEARER-Token");
		
		given()
		.auth()
		.oauth2("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")
		.body(map)
		
		.when()
		.post("https://api.github.com/user/repos")
		
		.then().log().all();
	}

}
