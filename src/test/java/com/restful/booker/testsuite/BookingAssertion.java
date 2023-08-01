package com.restful.booker.testsuite;

import com.restful.booker.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BookingAssertion extends TestBase {

    static ValidatableResponse response;
    @Before
    public void setUP() {
        response = given()
                .when()
                .get("/1")
                .then().statusCode(200);
    }
    @Test
    public void test001(){
        response.body("firstname",equalTo("Susan"));
    }
    @Test
    public void test002(){
        response.body("lastname", equalTo("Brown"));
    }
    @Test
    public void test003(){
        response.body("totalprice", equalTo(988));
    }
    @Test
    public void test004(){
        response.body("depositpaid", equalTo(true));
    }
    @Test
    public void test005(){
        response.body("bookingdates.checkin", equalTo("2023-03-15"));
    }
    @Test
    public void test006(){
        response.body("bookingdates.checkout", equalTo("2023-03-28"));
    }
    @Test
    public void test007(){
        response.body("additionalneeds", equalTo("Breakfast"));
    }

}