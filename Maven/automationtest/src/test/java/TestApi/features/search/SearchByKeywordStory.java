package TestApi.features.search;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.Ensure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;




public class SearchByKeywordStory {
    @Before
    public void baseurl(){
        RestAssured.baseURI="https://reqres.in/";
    }
    @Test
    public void CallAPIGetListUser(){
            given().queryParam("page","3")
                        .when().get("/api/users");

            Ensure.that("verify status code",response -> response.statusCode(200));
    }
    @Test
    public void CallAPIGetSingnUser(){
       given().pathParam("id","3")
               .when().get("/api/users/{id}");

       Ensure.that("verify status code", response -> response.statusCode(200));
    }
    @Test
    public void callAPIPostCreateUser(){
        Genbody body = new Genbody();
        body.setName("Tester");
        body.setJob("leader");
        given().contentType("application/json")
                .and().body(body)
                .when().post("/api/users");
        Ensure.that("verify status code", response -> response.statusCode(200));
    }

}