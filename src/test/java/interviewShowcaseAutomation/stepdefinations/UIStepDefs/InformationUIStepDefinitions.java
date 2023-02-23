package interviewShowcaseAutomation.stepdefinations.UIStepDefs;

import org.json.JSONObject;
import interviewShowcaseAutomation.constants.EndPoint;
import interviewShowcaseAutomation.context.TestContext;
import interviewShowcaseAutomation.pages.InformationPage;
import interviewShowcaseAutomation.factory.PageFactoryManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class InformationUIStepDefinitions {
    private final InformationPage informationPage;
    private final TestContext context;

    public InformationUIStepDefinitions(TestContext context){
        this.context = context;
        informationPage = PageFactoryManager.getInfoPage(context.driver);
    }

    @Given("I navigate to comments page")
    public void iMOnTheCommentsPage() {
        informationPage.load(EndPoint.DATA.url);
    }

    @Then("I capture the data on UI and validate with API")
    public void iGetTheDataFromUIAndValidateWithAPI()
    {

        JSONObject prodData = new JSONObject(informationPage.getProductData());

        Assert.assertEquals(context.getCurrentAPIResponse.getBody(), prodData.get("body"));
        Assert.assertEquals(context.getCurrentAPIResponse.getId(), prodData.get("id"));
        Assert.assertEquals(context.getCurrentAPIResponse.getName(), prodData.get("name"));
        Assert.assertEquals(context.getCurrentAPIResponse.getEmail(), prodData.get("email"));
        Assert.assertEquals(context.getCurrentAPIResponse.getPostId(), prodData.get("postId"));
    }
}
