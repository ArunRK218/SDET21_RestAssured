package Restassured_Test_Cases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import sdet21.GenericUtility.JavaUtility;
/**
 * using hashmap we can achieve key value pair
 * @author ARUN R
 *
 */
public class RMG_API_Project_TC_07_WithKeyValuePair {
	@Test
	public void createProjectUsingKeyValuePair() 
	{
		baseURI ="http://localhost";
		port =8084;
		
		JavaUtility jlib = new JavaUtility();
		HashMap map = new HashMap();
		map.put("createdBy", "KaavyaR");
		map.put("projectName", "ArunR"+jlib.getRandomNumber());
		map.put("status", "completed");
		map.put("teamSize", 380);
		
		//request specification 
		given()
		.contentType(ContentType.JSON)
		.body(map)
		
		//actual request
		.when()
		.post("addProject")
		
		//validation
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
}
