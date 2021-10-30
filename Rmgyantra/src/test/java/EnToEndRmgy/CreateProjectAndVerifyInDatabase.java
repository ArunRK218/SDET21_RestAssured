package EnToEndRmgy;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static  io.restassured.RestAssured.*;

import sdet21.GenericUtility.BaseAPIClass;
import sdet21.GenericUtility.EndPoints;
import sdet21.POJOclass.ProjectLibrary;


public class CreateProjectAndVerifyInDatabase extends BaseAPIClass {
	@Test
	public void createProjectAndVerifyInDB() throws Throwable
	{
		
		//create a project thru API
		ProjectLibrary pLib = new ProjectLibrary("Kaavya", "Arun "+jLib.getRandomNumber(), "On going", 100);
		
		Response res = given()
		.contentType(ContentType.JSON)
		.body(pLib)
		.when()
		.post(EndPoints.addProject);
		
		res.then().log().all();
		
		//capture the expected data
		String expData = rLib.getJsonData(res, "projectName");
		System.out.println(expData);
		
		//verify it in database
		String query = "select * from project";
		String actData = dLib.executeQueryAndGetData(query, 4, expData);
		
		//validate
		Assert.assertEquals(actData, expData);
		System.out.println("sucessful");
		
		
	}


}
