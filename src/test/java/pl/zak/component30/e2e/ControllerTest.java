package pl.zak.component30.e2e;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ActiveProfiles;
import pl.zak.component30.controller.Controller;
import pl.zak.component30.model.GlobalCart;
import pl.zak.component30.service.GlobalCartService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest
@ActiveProfiles("test")
@TestConfiguration
public class ControllerTest {
    @BeforeAll
    public static void insertSessionIdBeforeTests() {
        System.out.println("beforeAll");
        RestAssured.port = 8080;
    }

    @Test
    public void createNewSessionTest() {
        given()
                .when()
                .get("/api/startNewSession")
                .then()
                .statusCode(OK.value())
                .body(containsString("Cart with"))
                .body(containsString("has been created"));
    }

    @Test
    public void shouldAddNewProductToCart() {
        String sessionId = "test1234";
        String productCode = "Item1";
        int quantity = 5;
        GlobalCart.createNewClient("test1234");

        Response response = given()
                .header("sessionId", "test1234")
                .queryParam("productCode", productCode)
                .queryParam("quantity", quantity)
                .when()
                .post("/api/add");

        System.out.println("Response status: " + response.statusCode());
        System.out.println("Response body: " + response.body().asString());
        System.out.println("Response: " + response);
    }
}
