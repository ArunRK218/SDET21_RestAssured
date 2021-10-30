package ParameterAndAuthentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import sdet21.GenericUtility.JavaUtility;
import sdet21.POJOclass.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class RequestChainingForDelete {
	@Test
	public void createChainingForDelete() {
		
		baseURI ="http://localhost";
		port =8084;
		
		JavaUtility jlib = new JavaUtility();
		
		ProjectLibrary plib = new ProjectLibrary("Kaavya", "Arun"+jlib.getRandomNumber(), "Completed", 100);
		
		Response res = given()
		.contentType(ContentType.JSON)
		.body(plib)
		
		.when()
		.post("/addProject");
		
		String myProjectid = res.jsonPath().get("projectId");
		System.out.println(myProjectid);
		
		res.then().log().all();
		
		
		given()
		.pathParam("projID", myProjectid)
		.when()
		.delete("/projects/{projID}")
		
		.then().assertThat().statusCode(204).log().all();
	
	}

}
