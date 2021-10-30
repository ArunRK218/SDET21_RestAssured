package SDET21.ComplexResponseValidate;

import  org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;


public class HandlingStaticResponse {

	@Test
	public void staticResponse() {
		
		baseURI ="http://localhost";
		port =8084;
		
		String expdata = "TY_PROJ_212";
		
		//store all the responses
		Response res =when()
		.get("/projects");
		
		//capture the data using json path
		String actdata = res.jsonPath().get("[7].projectId");
		System.out.println(actdata);
		
		//validate
		Assert.assertEquals(actdata, expdata);
		System.out.println(actdata + " data verified");
		
		res.then().log().all();
	}
}
