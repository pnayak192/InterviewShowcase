package interviewShowcaseAutomation.apis;

import interviewShowcaseAutomation.constants.EndPoint;
import interviewShowcaseAutomation.context.TestContext;
import interviewShowcaseAutomation.pojoPayloadSerialization.usersAPI.CreateUser;
import interviewShowcaseAutomation.pojoResponseDeserialization.usersAPI.CreatedUser;
import interviewShowcaseAutomation.pojoResponseDeserialization.usersAPI.GetSingleUser;
import interviewShowcaseAutomation.pojoResponseDeserialization.usersAPI.GetUsersList;
import interviewShowcaseAutomation.utils.ReadRequestPayloadFile;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.util.HashMap;
import java.util.Map;

public class UsersAPI {
    private final TestContext context;

    private ReadRequestPayloadFile readRequestPayloadFile;

    public UsersAPI(TestContext context) {
        this.context = context;
    }

    public void createUserUsingPojo(CreateUser createUser){
//        Header header = new Header("content-type", "application/x-form-urlencoded");
//        Headers headers = new Headers(header);
        Map<String, Object> headers = new HashMap<String, Object>();
        headers.put("content-type", "application/json");
        headers.put("Accept", "*/*");
        headers.put("Connection", "keep-alive");
//        this.response = ApiRequest.postWithPayload(EndPoint.CREATEUSER.url,
//                readRequestPayloadFile.readJsonFile(context.getJsonPayLoadPath()));

        context.response = ApiRequest.postWithPojo(EndPoint.CREATEUSER.url, headers, createUser);
        context.createdUser = context.response.as(CreatedUser.class);

    }

    public void createUserUsingJson(){

        Map<String, Object> headers = new HashMap<String, Object>();
        headers.put("content-type", "application/json");
        headers.put("Accept", "*/*");
        headers.put("Connection", "keep-alive");

//        this.response = ApiRequest.postWithPayload(EndPoint.CREATEUSER.url,
//                readRequestPayloadFile.readJsonFile(context.getJsonPayLoadPath()));

        context.response = ApiRequest.postWithPayload(EndPoint.CREATEUSER.url,headers,
                ReadRequestPayloadFile.readJsonFile(context.getJsonPayLoadPath()));
        context.createdUser = context.response.as(CreatedUser.class);

    }

    public void getSingleUser(){
        Header header = new Header("content-type", "application/x-form-urlencoded");
        Headers headers = new Headers(header);

        context.response = ApiRequest.get(EndPoint.CREATEUSER.url,headers);
        context.getSingleUser = context.response.as(GetSingleUser.class);

    }

    public void getUsersList(){
        Header header = new Header("content-type", "application/x-form-urlencoded");
        Headers headers = new Headers(header);

        context.response = ApiRequest.get(EndPoint.USERSLIST.url,headers);
        context.getUsersList = context.response.as(GetUsersList.class);
    }
}
