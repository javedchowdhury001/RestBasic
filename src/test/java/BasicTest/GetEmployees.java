package BasicTest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetEmployees {

	@Test
	public void getEmployees() {

	
		System.out.println("********************* Get Place ***************************");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		String getPlaceResponse = given().log().all().when().get("/employees").then().assertThat().log().all()
				.statusCode(200).extract().response().asString();

		JsonPath js1 = ReUsableMethods.rawToJson(getPlaceResponse);
		System.out.println(js1);

		System.out.println("******************** Post Place ****************************");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		String Response = given().log().all().header("Content-Type", "application/json").body(payload.AddValue())
				.when().post("/create")
				.then().assertThat().log().all()
				.statusCode(200).extract().response().asString();
		
		System.out.println(Response);
		
		
		System.out.println("*********************** Get Place ****************************");

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		String getResponse = given().log().all().when().get("/employees").then().assertThat().log().all()
				.statusCode(200).extract().response().asString();

		System.out.println(getResponse);

	}
}