package TestFramework;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import resources.*;

public class excelDriven {

	@Test
	public void addBook() throws IOException {
		dataDriven d = new dataDriven();
		ArrayList data = d.getData("RestAddbook","RestAssured");

		HashMap<String, Object> map = new HashMap<>();
		map.put("name", data.get(1));
		map.put("isbn", data.get(2));
		map.put("aisle", data.get(3));
		map.put("author", data.get(4));

		/*
		 * HashMap<String, Object> map2 = new HashMap<>(); map.put("lat", "12");
		 * map.put("lng", "34"); map.put("location", map2);
		 */

		RestAssured.baseURI = "http://216.10.245.166";
		Response resp = given().header("Content-Type", "application/json").body(map).when().post("/Library/Addbook.php")
				.then().assertThat().statusCode(200).extract().response();
		
		JsonPath js = ReusableMethods.rawToJson(resp);
		String id = js.get("ID");
		System.out.println(id);
	}

	}

