package Demo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static java.lang.Math.log;
import static org.hamcrest.Matchers.equalTo;
import  io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response.*;

import java.util.Map;

public class Day4 {

    @Test(priority = 1)
    void testCookies(){

        given()
                .when()
                .get("https://www.google.com/")
                .then()
                .cookie("AEC","AZ6Zc-VzyvmoF4ju3YP7m_Hx-8MtbFO4m125pbGYYK7zSOxS-MrjjUgzyQ; expires=Tue, 27-May-2025 15:20:04 GMT; path=/; domain=.google.com; Secure; HttpOnly; SameSite=lax")
                .log().all();

    }
    @Test(priority = 2)
    void getCookiesInfo()
    {
        Response res=given()
                .when()
                .get("https://www.google.com/");
                //get Single cookie info

//                String cookie_value=res.getCookie("AEC");
//              System.out.println("Value of cookie is===>"+cookie_value);
            //  get all cookie\
          Map<String,String> cookies_value=res.getCookies();
        //  System.out.println(cookies_value.keySet());
        for(String k:cookies_value.keySet())
        {
            String cookie_value=res.getCookie(k);
            System.out.println(k+" "+cookie_value);
        }

    }
    @Test(priority=3)
    void getheader(){
        given()
                .when()
                .get("https://www.google.com/")
                .then()
                .header("Content-Type","text/html; charset=ISO-8859-1")
                .and()
                .header("Content-Encoding","gzip")
                 .log().headers();



    }





@Test(priority=4)
void getHeaders(){
    Response res=given()
                  .when()
               .get("https://www.google.com/");
            //get single header info
//            String headervalue=res.getHeader("Content-Type");
//            System.out.println("The value of content-type header is :"+headervalue);
           //get all header
    Headers myheader =res.getHeaders();
     for (Header hd:myheader)
    {
        System.out.println(hd.getName()+"  "+hd.getValue());
    }


}
}