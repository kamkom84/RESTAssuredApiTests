package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.when;

public class DELETE {

    @Test
    public void delete() {

        when().
                delete("https://reqres.in/api/users/2").
        then().
                statusCode(204);



    }

}
