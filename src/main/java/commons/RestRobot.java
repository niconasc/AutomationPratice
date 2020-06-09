package commons;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.when;

public class RestRobot {

    PropertiesManager propertiesManager = new PropertiesManager();

    public String[] getRequest(String endpoint, String chave) {
        String jsonRetorno = null;
        JsonPath json = when()
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
