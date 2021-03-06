package bodies;

import fakers.DataFaker;
import io.qameta.allure.Step;

public class DoRegisterBody {

    @Step("Create request body for user registration")
    public String doRegisterBody() {

        DataFaker dataFaker = new DataFaker();
        String email = dataFaker.generateEmail();
        String nameUser = dataFaker.generateName();

        String doRegisterBody = "{\n" +
                "  \"password\": \"foo1248345\",\n" +
                "  \"name\": " + "\"" + nameUser + "\"" + ",\n" +
                "  \"email\": " + "\"" + email + "\"" +
                "\n}";
        return doRegisterBody;
    }
}