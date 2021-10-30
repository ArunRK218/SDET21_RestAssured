package Restassured_Test_Cases;


import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import sdet21.POJOclass.ProjectLibrary;
/**
 * we will get (java.lang.IllegalArgumentException)
 * @author ARUN R
 *
 */
public class RMG_API_Project_TC_05_WithHTML {

	@Test
	public void createProjectWithHTML() {
		baseURI ="http://localhost";
		port =8084;
		
		ProjectLibrary plib = new ProjectLibrary("Kasss", "aksss", "on going", 100);
		
		given()
		.contentType(ContentType.HTML)
		.body(plib)
		
		.when()
		.post("addProject")
		
		.then()
		.assertThat()
		.statusCode(500)
		.log().all();
	}
}
