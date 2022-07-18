package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Delete_API {

    public String path;
    public String workspaceId;
    public String userId;
    public Map<String,String> variables;
    public String personalId;

    @BeforeTest
    public String loginAndGetToken() {

        RestAssured.baseURI = "https://api.octoperf.com";
        path = "/public/users/login";
        Map<String,Object> credentials = new HashMap<>();
        credentials.put("username","khidirovalisher@gmail.com");
        credentials.put("password","Alish198702");

       return  given()
               .queryParams(credentials)
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
    public void member_Of() {

        Response response = given()
                .header("Authorization", loginAndGetToken())
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
        Assert.assertEquals("n6Y1Q3gBeBgcu3OdpFvM", response.jsonPath().getString("id[1]"));
        Assert.assertEquals("ew7dI3gBIIglpdFcXqjg", response.jsonPath().getString("userId[1]"));

        workspaceId = response.jsonPath().getString("id[1]");
        userId = response.jsonPath().getString("userId[1]");

        variables = new HashMap<String,String>();
        variables.put("workspaceId", workspaceId);
        variables.put("userId", userId);
    }

    @Test(dependsOnMethods = {"member_Of"})
    public void createNewObject() {

        String body = "{\"id\":\"\",\"created\":\"2021-10-11T01:01:25.241Z\",\"lastModified\":\"2021-10-11T01:01:25.241Z\",\"userId\":\""+variables.get("userId")+"\",\"workspaceId\":\""+variables.get("workspaceId")+"\",\"name\":\"Octoperf\",\"description\":\"OctoperfProject\",\"type\":\"DESIGN\",\"tags\":[]}";

        Response response = given()
                .header("Authorization", loginAndGetToken())
                .contentType(ContentType.JSON)
                .and()
                .body(body)
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

    @Test(dependsOnMethods = {"member_Of","createNewObject"})
    public void updateNewObject() {

        String UpdatedBody = "{\"created\":1633914085241,\"description\":\"JAVA\",\"id\":\""+personalId+"\",\"lastModified\":1636923132290,\"name\":\"API\",\"tags\":[],\"type\":\"DESIGN\",\"userId\":\""+variables.get("userId")+"\",\"workspaceId\":\""+variables.get("workspaceId")+"\"}";

        Response response = given()
                .header("Authorization", loginAndGetToken())
                .contentType(ContentType.JSON)
                .body(UpdatedBody)
                .when()
                .put("/design/projects/" + personalId)
                .then()
                .statusCode(200)
                .log()
                .body()
                .extract()
                .response();

    }

    @Test(dependsOnMethods = {"member_Of","createNewObject","updateNewObject"})
    public void deleteObject() {

        Response response = given()
                .header("Authorization", loginAndGetToken())
                .contentType(ContentType.JSON)
                .when()
                .delete("/design/projects/" + personalId)
                .then()
                .statusCode(204)
                .log()
                .body()
                .extract()
                .response();

        Assert.assertEquals(204, response.statusCode());
    }
}
