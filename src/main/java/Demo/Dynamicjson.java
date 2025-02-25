package Demo;

import File.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.message.ReusableMessage;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Dynamicjson {
    @Test
    public void addBook()
    {
        RestAssured.baseURI="http://216.10.245.166";
        Response resp=given().header("Content-Type","application/json").body(Payload.Addbook("adsfs","6464")).when().post("Library/Addbook.php").then()
                .assertThat().statusCode(200).extract().response();
        //JsonPath js= JsonUtils.rawToJson(resp);

       // String id=js.get("Id");
       // System.out.println(id);


    }



}
