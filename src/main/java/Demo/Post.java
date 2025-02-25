package Demo;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static java.lang.Math.log;
import static org.hamcrest.Matchers.equalTo;
import  io.restassured.matcher.RestAssuredMatchers.*;


import java.util.HashMap;

public class Post {
    //1) Post request body using HashMap
    @Test
    void posthashmapdata(){

        HashMap data =new HashMap();

        data.put("name","Nitika");
        data.put("location","Basti");
        data.put("phone","123456");
        String courseArr[]={"C","C++"};
        data.put("courses",courseArr);
        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name",equalTo("Nitika"))
                .body("location",equalTo("123456"))
                .body("phone", equalTo("Basti"))
                .body("courses[0]",equalTo("C"))
                .body("courses[1]",equalTo("C++"))
                .header("Content-Type","application/json; charset=utf-8")
                .log().all();

    }
    //2) Post request body using JSONobject
    @Test
    void postjsondata() throws JSONException {

        JSONObject data=new JSONObject();
        data.put("name","Nitika");
        data.put("location","Basti");
        data.put("phone","123456");
        String courseArr[]={"C","C++"};
        data.put("courses",courseArr);
        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name",equalTo("Nitika"))
                .body("location",equalTo("123456"))
                .body("phone", equalTo("Basti"))
                .body("courses[0]",equalTo("C"))
                .body("courses[1]",equalTo("C++"))
                .header("Content-Type","application/json; charset=utf-8")
                .log().all();

    }
}
