package RmgProjects;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProject {

	@Test
	public void create() {
		
		//create the json data before request
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Ruparani");
		jobj.put("projectName", "Deepaksb");
		jobj.put("status", "completed");
		jobj.put("teamsize", 30);
		
		//set the request specification before sending the request 
		
		RequestSpecification reqspec =RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jobj);
		
		
		//send the request 
				Response res = reqspec.post("http://localhost:8084/addProject");
				res.then().assertThat().statusCode(201);
				
				// print the response 
				System.out.println(res.asString());
				System.out.println(res.prettyPrint());
				System.out.println(res.prettyPeek());

//				// validate the response
//				ValidatableResponse validate = res.then();
//				validate.assertThat().statusCode(201);
//				validate.assertThat().contentType("application/json");
//				validate.log().all();
	}
}
