import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class metaWeatherTest1 {
    @Test
    public void getLocation(){
        /*
        * Method: GET
        * URL: https://www.metaweather.com/api/location/44418/
        * TODO: verify that:
        * 1)status-code == 200
        * */
        given().baseUri("https://www.metaweather.com/")
                .basePath("api/location/44418/")
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200);
    }
}
