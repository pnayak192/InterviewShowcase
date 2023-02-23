package interviewShowcaseAutomation.apis;

import interviewShowcaseAutomation.constants.EndPoint;
import interviewShowcaseAutomation.context.TestContext;
import interviewShowcaseAutomation.pojoResponseDeserialization.postsAPI.GetCurrent;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class CommentsAPI {

    private final TestContext context;

    public CommentsAPI(TestContext context){
        this.context = context;
        context.getCurrentAPIResponse = getComments();
    }

    private GetCurrent getComments(){
        Header header = new Header("content-type", "application/x-form-urlencoded");
        Headers headers = new Headers(header);
        context.response = ApiRequest.get(EndPoint.DATA.url, headers);
        return context.response.as(GetCurrent.class);
    }

}
