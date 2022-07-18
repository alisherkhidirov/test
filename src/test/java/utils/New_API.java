package utils;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class New_API {

    public String path;
    public String id;
    public String userId;
    public String personalId;
    public String updatedUserId;
    public static Map<String,String> variables;

    @BeforeTest
    public String setLoginAndGetToken() {

        RestAssured.baseURI = "https://api.octoperf.com";
        path = "/public/users/login";

        Map<String,Object> map = new HashMap<>();
        map.put("username","khidirovalisher@gmail.com");
        map.put("password","Alish198702");

        return given()
                .queryParams(map)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post(path)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .get("token");

    }

    @Test
    public void memberOf() {

        Response response = given()
                .header("Authorization", setLoginAndGetToken())
                .get("/workspaces/member-of")
                .then()
                .statusCode(200)
                .log()
                .body()
                .extract()
                .response();

        Assert.assertEquals("",response.jsonPath().getString("description[1]"));
        Assert.assertEquals("Default",response.jsonPath().getString("name[1]"));
        Assert.assertEquals("n6Y1Q3gBeBgcu3OdpFvM",response.jsonPath().getString("id[1]"));
        Assert.assertEquals("ew7dI3gBIIglpdFcXqjg",response.jsonPath().getString("userId[1]"));

        id = response.jsonPath().getString("id[1]");
        userId = response.jsonPath().getString("userId[1]");

        variables = new HashMap<String,String>();
        variables.put("userId",userId);
        variables.put("workspaceId", id);

    }
    @Test(dependsOnMethods = {"memberOf"})
    public void createNewObject() {

        String requestBody = "{\"id\":\"\",\"created\":\"2021-10-11T01:01:25.241Z\",\"lastModified\":\"2021-10-11T01:01:25.241Z\",\"userId\":\""+variables.get("userId")+"\",\"workspaceId\":\""+variables.get("workspaceId")+"\",\"name\":\"Ali\",\"description\":\"Octoperf Project\",\"type\":\"DESIGN\",\"tags\":[]}";

        Response response = given()
                .header("Authorization", setLoginAndGetToken())
                .contentType(ContentType.JSON)
                .and()
                .body(requestBody)
                .when()
                .post("/design/projects")
                .then()
                .statusCode(201)
                .log()
                .body()
                .extract()
                .response();


        personalId = response.jsonPath().getString("id");

    }

    @Test(dependsOnMethods = {"memberOf","createNewObject"})
    public void changeExistingObject() {

        String updatedBody = "{\"created\":1633914085241,\"description\":\"Updated Project\",\"id\":\""+personalId+"\",\"lastModified\":1634865044723,\"name\":\"Alisher\",\"tags\":[],\"type\":\"DESIGN\",\"userId\":\""+variables.get("userId")+"\",\"workspaceId\":\""+variables.get("workspaceId")+"\"}";

        Response response = given()
                .header("Authorization",setLoginAndGetToken())
                .contentType(ContentType.JSON)
                .body(updatedBody)
                .when()
                .put("/design/projects/"+personalId)
                .then()
                .statusCode(200)
                .log()
                .body()
                .extract()
                .response();

    }
    @Test(dependsOnMethods = {"memberOf","createNewObject","changeExistingObject"})
    public void deleteUpdatedObject() {

        RestAssured.given()
                .header("Authorization",setLoginAndGetToken())
                .when()
                .delete("/design/projects/"+personalId)
                .then()
                .log().status();
    }
}
