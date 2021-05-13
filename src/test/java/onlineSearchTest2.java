import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class onlineSearchTest2 {
    @Test
    public void getLocation(){
        /*
         * Method: POST
         * URL: https://api.novaposhta.ua/v2.0/json/
         * Api key: dc2f0af65b6cf4ac7ecb3e9f4f6173f1
         * TODO: verify that:
         * 1)status-code == 200
         * */
        String JSON_STRING = "{\n" +
                "\"apiKey\": \"dc2f0af65b6cf4ac7ecb3e9f4f6173f1\",\n" +
                " \"modelName\": \"Address\",\n" +
                "    \"calledMethod\": \"searchSettlements\",\n" +
                "    \"methodProperties\": {\n" +
                "        \"CityName\": \"київ\",\n" +
                "        \"Limit\": 5\n" +
                "    }\n" +
                "}";

        Response response = given()
                .baseUri("https://api.novaposhta.ua/")
                .basePath("v2.0/json/")
                .body(JSON_STRING)
                .when()
                .post();
                /*.then()
                .statusCode(200);*/

        response.then().assertThat().statusCode(200);
        response.then().body("\"success\"", contains(true));
    }
}
