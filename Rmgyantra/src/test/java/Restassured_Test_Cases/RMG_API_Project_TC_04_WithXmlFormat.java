package Restassured_Test_Cases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import sdet21.POJOclass.ProjectLibrary;
/**
 * we will get (javax.xml.bind.MarshalException)
 * @author ARUN R
 *
 */
public class RMG_API_Project_TC_04_WithXmlFormat {

	@Test
	public void createProjectWithXml() {
		baseURI ="http://localhost";
		port =8084;
		
		ProjectLibrary plib = new ProjectLibrary("Kasss", "aksss", "on going", 100);
		
		given()
		.contentType(ContentType.XML)
		.body(plib)
		
		.when()
		.post("addProject")
		
		.then()
		.assertThat()
		.statusCode(409)
		.log().all();
	}
}
