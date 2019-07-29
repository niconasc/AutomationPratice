package commons;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class RestRobot {

    PropertiesManager propertiesManager = new PropertiesManager();

    public String[] getRequest(String endpoint, String chave) {
        String jsonRetorno = null;
        JsonPath json = RestAssured.when()
                .get(endpoint)
                .then()
                .extract()
                .response()
                .jsonPath();

        jsonRetorno = json.getString(chave)
                .replace(" ", "")
                .replace("[", "")
                .replace("]", "");

        String[] retornoQuery;


        if (jsonRetorno.contains(",")) {
            return retornoQuery = jsonRetorno
                    .split(",");
        } else {
            return retornoQuery = jsonRetorno
                    .split(";");
        }
    }
}
