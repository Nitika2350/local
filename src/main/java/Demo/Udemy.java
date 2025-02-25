package Demo;

import File.Payload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class Udemy {
    public static void main(String[] args)
    {
        //validate if Add Place API is working as expected
        //Add place--> Update Place with New Address --> Get Place to validate if new address is present
        RestAssured.baseURI="https://rahulshettyacademy.com";
      String response=  given().log().all().queryParam("key","qaclick123").header("Contemt-Type","application/json").body(Payload.AddPlace())
                .when().post("maps/api/place/add/json").then()
                .log().all().assertThat().statusCode(200)
                .body("scope",equalTo("APP"))
                .header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
                System.out.println(response);
                JsonPath js=new JsonPath(response); //for parsing json
                 String PlaceId=js.getString("Place_id");
                 System.out.println(PlaceId);
                 //update Place
                 String newAddress="Summer Walk,Africa";
              given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                      .body("{\n" +
                              "\"Place_id\":\""+PlaceId+"\",\n" +
                              "\"address\":\""+newAddress+"\",\n" +
                              "\"key\":\"qaclick123\"\n" +
                              "}\n").
                      when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200)
                      .body("msg",equalTo("Address successfully updated"));
               //Get Place
              String getPlaceResponse = given().log().all().queryParam("key","qaclick123").queryParam("Place_id",PlaceId).
                      when().get("maps/api/place/get/json").then().assertThat().log().all().statusCode(200).extract().response().asString();
              JsonPath js1=new JsonPath(getPlaceResponse);
              String actualAddress= js1.getString("address");
              System.out.println(actualAddress);
        Assert.assertEquals(actualAddress,newAddress);


    }
}
