package ru.netology.postman;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MobileBankApiTest {
    @Test
    void shouldPostDemoAccounts() {
        given()
                .baseUri("https://postman-echo.com")
                .body("{n" +
                        "  \"demo_accounts\":[\n" +
                        "    {\n" +
                        "      \"id\":1,\n" +
                        "      \"name\":\"Текущий счёт\",\n" +
                        "      \"number\":\"•• 0668\",\n" +
                        "      \"balance\":992821429,\n" +
                        "      \"currency\":\"RUB\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\":2,\n" +
                        "      \"name\":\"Текущий счёт\",\n" +
                        "      \"number\":\"•• 9192\",\n" +
                        "      \"balance\":2877210,\n" +
                        "      \"currency\":\"USD\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\":3,\n" +
                        "      \"name\":\"Текущий зарплатный счёт\",\n" +
                        "      \"number\":\"•• 5257\",\n" +
                        "      \"balance\":1204044,\n" +
                        "      \"currency\":\"RUB\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("demo_accounts.currency.first()",equalTo("RUB"))
                ;
    }
}
