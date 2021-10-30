package Restassured_Test_Cases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.port;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import sdet21.GenericUtility.JavaUtility;
import sdet21.POJOclass.ProjectLibrary;
/**
 * here we will run TC with status as created 
 * @author ARUN R
 *
 */
public class RMG_API_Project_TC_08_WithStatusCreated {

	@Test
	public void createProjectWithStatusCreated() throws FileNotFoundException {
			baseURI ="http://localhost";
			port =8084;
			
			JavaUtility jlib = new JavaUtility();
			//read the file
			ProjectLibrary plib = new ProjectLibrary("Kaavya", "Arun"+jlib.getRandomNumber(), "created", 100);
			
			//request specification
			given()
			.contentType(ContentType.JSON)
			.body(plib)

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
