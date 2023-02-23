package interviewShowcaseAutomation.context;

import interviewShowcaseAutomation.domainobjects.BillingDetails;
import interviewShowcaseAutomation.domainobjects.Cookies;
import interviewShowcaseAutomation.domainobjects.UserDetails;
import interviewShowcaseAutomation.pojoResponseDeserialization.postsAPI.GetCurrent;
import interviewShowcaseAutomation.pojoResponseDeserialization.usersAPI.CreatedUser;
import interviewShowcaseAutomation.pojoResponseDeserialization.usersAPI.GetSingleUser;
import interviewShowcaseAutomation.pojoResponseDeserialization.usersAPI.GetUsersList;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;

public class TestContext {
    public WebDriver driver;
    public BillingDetails billingDetails;
    public UserDetails userDetails;
    public Cookies cookies;

    public GetCurrent getCurrentAPIResponse;

    public CreatedUser createdUser;

    public GetSingleUser getSingleUser;

    public GetUsersList getUsersList;

    public Response response;

    public String getJsonPayLoadPath() {
        return JsonPayLoad;
    }

    public void setJsonPayLoadPath(String jsonPayLoad) {
        JsonPayLoad = jsonPayLoad;
    }

    private String JsonPayLoad;

    public TestContext(){
        cookies = new Cookies();
        cookies.setCookies(new io.restassured.http.Cookies());
    }
}
