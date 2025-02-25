package Demo;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static java.lang.Math.log;
import static org.hamcrest.Matchers.equalTo;
import  io.restassured.matcher.RestAssuredMatchers.*;

import java.util.HashMap;


public class Demo {
    int id;
    @Test(priority = 1)
     void listUser() {
        String url = "https://reqres.in/api/users?page=2";
        given()
                .when()
                .get(url)
                .then()
               // .assertThat()
                .statusCode(200)
                .body("page", equalTo(2))
                .log().all();
    }
    @Test(priority = 2)
           void createUser()
        {
            HashMap data=new HashMap();
            data.put("name","paven");
            data.put("job","trainer");
             id = given()
                    .contentType("application/json")
                    .body(data)
                    .when()
                    .post("https://reqres.in/api/users/")
                    .jsonPath().getInt("id");
//                     .then()
//                     .statusCode(201)
//                     .log().all();
        }
    @Test(priority = 3, dependsOnMethods = {"createUser"})
    void updateUser()
    {
        HashMap data=new HashMap();
        data.put("name","Nitika");
        data.put("job","trainer");
        given()
                .contentType("application/json")
                .body(data)
                .when()
                .put("https://reqres.in/api/users/"+id)
                .then()
                .statusCode(200)
                .log().all();
    }
@Test(priority = 4)
    void deleteUser()
{
    given()
            .when()
            .delete("https://requres.in/api/users/"+id)
       .then()
            .statusCode(204)
            .log().all();

}


}
