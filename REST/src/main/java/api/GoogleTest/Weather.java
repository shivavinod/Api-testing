package api.GoogleTest;

import org.hamcrest.Matchers;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

public class Weather {
	
	@Test
	public void getWeatherinfo() {
		RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/weather";
		String response = RestAssured.given().param("q", "Bangalore")
				.param("appid", "17e5c69afcef0f16365a6c3b0cba4400").when()
				.get().then().extract().asString();
		System.out.println("Response is :- " + response);
		
		Reporter.log("Response is: " + response, true);
		ValidatableResponse res = RestAssured.given().param("q", "Bangalore")
				.param("appid", "17e5c69afcef0f16365a6c3b0cba4400").when()
				.get().then();

		res.statusCode(200);
		Reporter.log("Verified the Status code successfully", true);

		res.contentType(ContentType.JSON);
		
		
		Object countryName = res.extract().response().path("sys.country");
		System.out.println("Country Name is " + countryName);

		Object coordinates = res.extract().response().path("coord.lon");
		System.out.println("Country Name is " + coordinates);

		
		Object x = res.extract().response().path("main.temp");
		System.out.println("********>>>*** " + x);
		
		JsonPath path = new JsonPath(response);
		Object countryNm = path.get("sys.country");
		System.out.println("Country Name: " + countryNm);

		res.body("sys.country", Matchers.notNullValue());
		res.body("sys.country", Matchers.equalToIgnoringCase("IN"));
		Reporter.log("Country code has verified successfully", true);

		
	}

}
