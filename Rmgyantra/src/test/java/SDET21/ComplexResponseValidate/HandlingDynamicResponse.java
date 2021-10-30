package SDET21.ComplexResponseValidate;

import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;



import java.util.List;

public class HandlingDynamicResponse {
	@Test
	public void dynamicResponse() {
		
		baseURI ="http://localhost";
		port =8084;
		//store the response
		String expected= "competed";
		Response res = when()
		.get("/projects");
		
		//capture all the project name and store it in list of string 
		List<String> projectName =res.jsonPath().get("status");
		for(String actual:projectName)
		{
			if(actual.equalsIgnoreCase(expected))
			{
			Assert.assertEquals(actual, expected);
			System.out.println(actual + " data present");
			break;
			}
		}
		
		//validate
		res.then().log().all();
	}

}
