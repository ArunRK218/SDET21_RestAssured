package Restassured_Test_Cases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.port;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
/**
 * Status = Passed
 * @author ARUN R
 *
 */

public class RMG_API_Project_TC_06_JsonFilePath {
	
	@Test
public void createProjectUsingJasonFile() throws FileNotFoundException {
		baseURI ="http://localhost";
		port =8084;
		//read the file
		FileInputStream fis = new FileInputStream("./data.json");
		
		//request specification
		given()
		.contentType(ContentType.JSON)
		.body(fis)

		//actual request
		.when()
		.post("addProject")
		
		//validate
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();

	}
}
