package entities;

import specifications.RequestSpec;
import specifications.ResponseSpec;
import io.qameta.allure.Step;
import io.restassured.builder.MultiPartSpecBuilder;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class Avatar {

    @Step("Add avatar for user")
    public void addAvatar(File file, String email) {
        given()
                .spec(new RequestSpec().defaultRequestSpec()
                        .multiPart(new MultiPartSpecBuilder(file)
                                .controlName("avatar")
                                .fileName(file.getName())
                                .build())
                        .multiPart(new MultiPartSpecBuilder(email)
                                .controlName("email")
                                .build())
                        .contentType("multipart/form-data"))
        .when()
                .post("/tasks/rest/addavatar")
        .then()
                .spec(new ResponseSpec().defaultResponseSpec())
                .statusCode(SC_OK)
                .extract().response();
    }
}