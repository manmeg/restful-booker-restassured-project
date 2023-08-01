package com.restful.booker.crudtest;


import com.restful.booker.model.BookingDates;
import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BookingCrudTest extends TestBase {

    static ValidatableResponse response;
    BookingPojo bookingPojo = new BookingPojo();


    @Test
    public void test01_GetBooking() {
        response = given()
                .when()
                .get("/1")
                .then().log().all().statusCode(200);
    }

    @Test
    public void test02_CreateBooking() {

        bookingPojo.setFirstname("Raj");
        bookingPojo.setLastname("rajvan");
        bookingPojo.setTotalprice(155);
        bookingPojo.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2020-01-01");
        bookingDates.setCheckout("2020-02-04");
        bookingPojo.setBookingdates(bookingDates);
        bookingPojo.setAdditionalneeds("Breakfast");

        response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(bookingPojo)
                .post()
                .then().log().all().statusCode(200);
    }

    @Test
    public void test003_PutBooking() {
        bookingPojo.setFirstname("Raja");
        bookingPojo.setLastname("rajvan");
        bookingPojo.setTotalprice(155);
        bookingPojo.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2020-01-01");
        bookingDates.setCheckout("2020-02-04");
        bookingPojo.setBookingdates(bookingDates);
        bookingPojo.setAdditionalneeds("Breakfast");
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(bookingPojo)
                .put("/3418");
        response.then().log().all().statusCode(200);

    }

    @Test
    public void test004_PartialUpdateBooking() {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Raj");
        bookingPojo.setLastname("megji");
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(bookingPojo)
                .patch("/3418");
        response.then().log().all().statusCode(200);
    }
}