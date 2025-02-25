package Demo;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static java.lang.Math.log;
import static org.hamcrest.Matchers.equalTo;
import  io.restassured.matcher.RestAssuredMatchers.*;
import org.testng.annotations.Test;

public class Day3 {

   @Test
   void testQueryAndPathParameter()
    {
        //https://requres.in/api/users?page=2&id=5
        given()
                .pathParams("mypath","users")//path parameter
            //    .queryParam("mypath2","users") //path parameter
                .queryParam("page",2)
                .queryParam("id",5)
                .when()
                .get("https://reqres.in/api/{mypath}")
                .then()
                        .statusCode(200)
                        .log().all();

    }
}
