package Restassured_Test_Cases;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import sdet21.GenericUtility.JavaUtility;
import sdet21.POJOclass.ProjectLibrary;

public class RMG_API_Project_TC_01 {
	
	@Test
	public void createProject() {
		
		baseURI ="http://localhost";
		port =8084;
		JavaUtility jlib = new JavaUtility();
		
		ProjectLibrary plib = new ProjectLibrary("Kaavya", "Arun"+jlib.getRandomNumber(), "completed", 40);
		
		
		given()
		.contentType(ContentType.JSON)
		.body(plib)
		
		.when()
		.post("addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}

}
