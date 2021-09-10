package api.assertions;

import api.bodies.RequestUserBody;
import api.bodies.ResponseUserBody;
import io.qameta.allure.Step;

import static org.testng.AssertJUnit.assertEquals;

public class UserWithTasksAssertions {

    @Step("Check user response body with tasks")
    public static void checkSuccessfulResponseBodyUserWithTasks(RequestUserBody expected, ResponseUserBody actual) {
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getEmail(), actual.getEmail());
    }
}