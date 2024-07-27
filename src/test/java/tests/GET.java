package tests;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GET {

    @Test(priority = 1)
    void test1_GET() {

        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }

    @Test(priority = 2)
    void test2_GET() {

        given().
                get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[0]", equalTo(7))
                .body("data.first_name", hasItems("Michael", "Lindsay"));

    }


}
