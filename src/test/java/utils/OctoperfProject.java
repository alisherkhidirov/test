package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class OctoperfProject {

    public String path;
    public String userId;
    public String id;
    public String uniquePersonalUserId;
    public static Map<String,String> variables;

    @BeforeTest
    public String setLoginAndGetToken() {

        RestAssured.baseURI = "https://api.octoperf.com";
        path = "/public/users/login";

        Map<String,Object> map = new HashMap<>();
        map.put("username","khidirovalisher@gmail.com");
        map.put("password","Alish198702");

        return RestAssured.given()
                .queryParams(map)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
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

        Response response = RestAssured.given()
                .header("Authorization", setLoginAndGetToken())
                .when()
                .get("/workspaces/member-of")
                .then()
                .statusCode(200)
                .log()
                .body()
                .extract()
                .response();
        Assert.assertEquals("", response.jsonPath().getString("description[1]"));
        Assert.assertEquals("Default", response.jsonPath().getString("name[1]"));
        Assert.assertEquals("ew7dI3gBIIglpdFcXqjg", response.jsonPath().getString("userId[1]"));
        Assert.assertEquals("n6Y1Q3gBeBgcu3OdpFvM", response.jsonPath().getString("id[1]"));

        userId = response.jsonPath().getString("userId[1]");
        id = response.jsonPath().getString("id[1]");

        variables = new HashMap<String,String>();
        variables.put("userId", userId);
        variables.put("workspaceId", id);
    }

    @Test(dependsOnMethods = {"memberOf"})
    public void createNewObject() {

        String newObjectBody = "{\"id\":\"\",\"created\":\"2021-10-11T01:01:25.241Z\",\"lastModified\":\"2021-10-11T01:01:25.241Z\",\"userId\":\""+variables.get("userId")+"\",\"workspaceId\":\""+variables.get("workspaceId")+"\",\"name\":\"AlisherTest\",\"description\":\"PASS\",\"type\":\"DESIGN\",\"tags\":[]}";

                Response response = RestAssured.given()
                .header("Authorization", setLoginAndGetToken())
                .contentType(ContentType.JSON)
                .body(newObjectBody)
                .when()
                .post("/design/projects")
                .then().statusCode(201).log()
                .body()
                .extract()
                .response();

                Assert.assertEquals(201, response.getStatusCode());
                Assert.assertEquals("AlisherTest", response.jsonPath().getString("name"));
                Assert.assertEquals("PASS", response.jsonPath().getString("description"));


                uniquePersonalUserId = response.jsonPath().getString("id");
    }

    @Test(dependsOnMethods = {"memberOf","createNewObject"})
    public void updateNewObject() {

        String updatedBody = "{\"created\":1633914085241,\"description\":\"Changed\",\"id\":\""+uniquePersonalUserId+"\",\"lastModified\":1634940930598,\"name\":\"AlisherChangedTest\",\"tags\":[],\"type\":\"DESIGN\",\"userId\":\""+variables.get("userId")+"\",\"workspaceId\":\""+variables.get("workspaceId")+"\"}";

        Response response = RestAssured.given()
                .header("Authorization", setLoginAndGetToken())
                .contentType(ContentType.JSON)
                .and()
                .body(updatedBody)
                .when()
                .put("/design/projects/"+uniquePersonalUserId)
                .then().statusCode(200)
                .log()
                .body()
                .extract()
                .response();
    }

    @Test(dependsOnMethods = {"memberOf","createNewObject","updateNewObject"})
    public void deleteUpdatedObject() {

        Response response = RestAssured.given()
                .header("Authorization", setLoginAndGetToken())
                .when()
                .delete("/design/projects/"+uniquePersonalUserId)
                .then()
                .statusCode(204)
                .extract()
                .response();
        Assert.assertEquals(204, response.getStatusCode());
    }
}
