package Demo;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Parsingjsonresponse {
    @Test(priority = 1)
    void testJsonResponse(){
//        given()
//                .contentType("ContentType.JSON")
//                .when()
//                .get("http://localhost:3000/Students")
//                .then()
//                .statusCode(200)
//                .header("Content-Type","application/json; charset=UTF-8")
//                .body("Students[2].location",equalTo("Noida"));

        Response res=given()
                .contentType("ContentType.JSON")
                .when()
                .get("http://localhost:3000/Students");
        Assert.assertEquals(res.getStatusCode(),200);

    }
}
