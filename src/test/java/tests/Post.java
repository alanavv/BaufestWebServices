package tests;

import data.RestUtils;
import io.restassured.http.ContentType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Post
{
    public static JSONObject request = new JSONObject();
    public static JSONObject requestCategory = new JSONObject();
    public static JSONObject requestTags = new JSONObject();

    @BeforeMethod
    public void postData()
    {
//        request.put("name", RestUtils.getPetName());
//        requestCategory.put("name", RestUtils.getPetCategory());
//        requestTags.put("name", RestUtils.getPetTags());
//        request.put("status", "available");
//
//        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
//        jsonObjects.add(requestCategory);
//        request.put("category", jsonObjects);
//
//        List<JSONObject> jsonObjs = new ArrayList<JSONObject>();
//        jsonObjs.add(requestTags);
//        request.put("tags", jsonObjs);

        request.put("name", RestUtils.getPetName());

    }

    @Test
    public void testPost()
    {
        given().
                baseUri("https://petstore.swagger.io").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                post("/v2/pet").
        then().
                log().all().
                assertThat().statusCode(200);
    }

}
