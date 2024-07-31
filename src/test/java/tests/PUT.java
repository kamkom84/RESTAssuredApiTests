package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PUT {

    @Test
    public void put() {

        JSONObject request = new JSONObject();

        request.put("name", "Popeye");
        request.put("job", "sailor");

        System.out.println(request.toJSONString());

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("https://reqres.in/api/users/2").
                then().
                statusCode(200).
                log().all();

    }

}
