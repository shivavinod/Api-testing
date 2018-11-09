package api.GoogleTest;

import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class WeatherDataProvider {
	
	
	String currentDir="C:\\Users\\VINODKUMAR\\Desktop\\TestData.xlsx";
	
	@DataProvider(name="PositiveTestScenarios")
	public Object[][] fetchPositiveTestData() throws Exception
	{
		ExcelReaderPoi excel=new ExcelReaderPoi();
		return excel.readFilenSheet(currentDir, "PositiveTestCaseData");
	}
	
	@Test(priority=-1,dataProvider="PositiveTestScenarios")
	public void verifyWeatherInfoWithPositiveData(Map mObj)
	{
		RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/weather";
		String cityName=mObj.get("City Name")+","+mObj.get("Country Code");
		ValidatableResponse response = RestAssured.given().param("q", cityName)
				.param("appid", mObj.get("App ID")).when()
				.get().then();

		Reporter.log("Test Case Name is: " + mObj.get("Test Case Name"), true);
		Reporter.log("Response is: " + response.extract().asString(), true);
		
		String stsCode=(String)mObj.get("Status Code");
		int statusCode=Integer.parseInt(stsCode);
		response.statusCode(statusCode);
		Reporter.log("Verified the Status code successfully", true);
		response.contentType(ContentType.JSON);

		response.body("sys.country", Matchers.notNullValue());
		response.body("sys.country", Matchers.equalToIgnoringCase((String)mObj.get("Country Code")));
		Reporter.log("Country code has verified successfully", true);
		
		response.body("name", Matchers.notNullValue());
		response.body("name", Matchers.equalToIgnoringCase((String)mObj.get("City Name")));
		Reporter.log("City name has verified successfully", true);

	}

}
