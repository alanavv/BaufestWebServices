package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Put
{
    @Test
    public void testPut()
    {
        JSONObject request = new JSONObject();

        request.put("name","Laika");

        System.out.println(request.toJSONString());

        given().
                baseUri("https://petstore.swagger.io").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                put("/v2/pet").
        then().
                log().all().
                assertThat().statusCode(200);
        
    }
}
