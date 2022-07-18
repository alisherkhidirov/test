import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class API {

    public WebDriver driver;

    @Test(description = "GET")
    public void test1() {
        String url = "https://employee-management-39848.herokuapp.com/api/employees";

        given()
                .get(url)
                .then()
                .log()
                .body();
    }


    @Test()
    public void test2() {
        RestAssured.baseURI = "https://employee-management-39848.herokuapp.com/api/employees";
        RequestSpecification requestSpecification = given();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", "ali-baba");
        jsonObject.put("lastName", "qwerty");
        jsonObject.put("role", "sdet");
        jsonObject.put("id", "7777");
        jsonObject.put("department", "HR");


        requestSpecification.headers("Content-Type", ContentType.JSON);
        requestSpecification.body(jsonObject);

        Response response = requestSpecification.request(Method.POST);

    }

    @Test
    public void test3() {

        String url = "https://employee-management-39848.herokuapp.com/api/employees";

        given()
                .get(url)
                .then()
                .statusCode(200)
                .log()
                .everything();
    }

    @Test()
    public void test44() {

            String url = "https://api.octoperf.com/design/projects";
            String token = "aff89434-eb30-4b80-888c-5866e101154f";

            Map<String,String> object = new HashMap<>();
        object.put("id","");
        object.put("userId","ew7dI3gBIIglpdFcXqjg");
        object.put("workspaceId","n6Y1Q3gBeBgcu3OdpFvM");
        object.put("name","James");
        object.put("description","New Test");



            given()
                    .auth()
                    .oauth2(token)
                    .contentType(ContentType.JSON)
                    .body(object)
                    .when()
                    .post(url)
                    .body().prettyPeek();
        }
    }


