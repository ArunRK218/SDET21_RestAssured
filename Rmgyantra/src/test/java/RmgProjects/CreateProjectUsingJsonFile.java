package RmgProjects;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CreateProjectUsingJsonFile {
	
	@Test
	public void createProjectUsingJasonFile() throws FileNotFoundException {
		
		//read the file
		FileInputStream fis = new FileInputStream("./data.json");
		
		//request specification
		given()
		.contentType(ContentType.JSON)
		.body(fis)

		//actual request
		.when()
		.post("http://localhost:8084/addProject")
		
		//validate
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}

}
