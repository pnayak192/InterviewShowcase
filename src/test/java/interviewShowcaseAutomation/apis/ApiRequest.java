package interviewShowcaseAutomation.apis;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiRequest extends ReqSpecBuilder {

    static final Logger logger = LogManager.getLogger(ApiRequest.class);

    public static Response post(String endPoint, Headers headers,
                                HashMap<String, Object> formParams, Cookies cookies) {
        return given(getRequestSpec()).
                headers(headers).
                formParams(formParams).
                cookies(cookies).
                when().
                post(endPoint).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response get(String endPoint, Headers headers) {
        return given(getRequestSpec()).
                headers(headers).
                expect().
                defaultParser(Parser.JSON).
                when().
                get(endPoint).
                then().spec(getResponseSpec()).
                log().
                all().
                extract().
                response();
    }

    public static Response postWithPayload(String endPoint, Map<String,Object> headers, String payLoad) {
        return given(getRequestSpec()).
                headers(headers).
                when().
                body(payLoad).
                post(endPoint).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response postWithPojo(String endPoint, Map<String,Object> headers, Object obj) {
        return given(getRequestSpec()).
                headers(headers).
                when().
                body(obj).
                post(endPoint).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Boolean validateResponseSchema(String fileName, Response response) {
        logger.info("Validating Response SCHEMA using Schema Validator");
        String path = System.getProperty("user.dir") + File.separator + "src/test/resources/schemaFiles" +
                File.separator;
        try {
            response.then().assertThat().contentType(ContentType.JSON).and()
                    .body(JsonSchemaValidator.
                            matchesJsonSchema(new File(path + fileName)));
            return true;
        } catch (Exception e) {
            logger.error("Exception occurred : " + e);

            return false;
        }
    }
}
