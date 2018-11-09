package api.GoogleTest;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import api.testing.google.GoogleApiTest;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GoogleApi {

	@Test
    public void googleApiTest() {
		/*RequestSpecification requestSpecification = new RestConfiguration().getRequestSpecification();
        requestSpecification.queryParam("q", "turing");
        Response response =
                new RestConfiguration().getResponse(requestSpecification, EndPoint.GOOGLE_API, HttpStatus.SC_OK);
        //Google google = response.as(Google.class, ObjectMapperType.GSON);*/
}
}
