import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostAPITest {

    @Test
    public void testPOSTAPI() throws JSONException {

    	RestAssured.baseURI = "https://reqres.in/api/users";
        RequestSpecification request = RestAssured.given();
        
        JSONObject requestparam = new JSONObject();
        requestparam.put("name", "Vipin");
        requestparam.put("job", "leader");

        request.body(requestparam.toString());
        request.header("Content-Type", "application/json");

        Response resp = request.post();
        System.out.println(resp);
        System.out.println(resp.asString());
        String body = resp.getBody().asString();
        JsonPath path = new JsonPath(body);

        System.out.println(path); // json format

        int statuscode = resp.getStatusCode();
        Assert.assertEquals(statuscode, 201);
    }

    public static void main(String[] args) throws JSONException {
        PostAPITest test = new PostAPITest();
        test.testPOSTAPI();
    }
}
