package interviewShowcaseAutomation.stepdefinations.UIStepDefs;

import interviewShowcaseAutomation.constants.EndPoint;
import interviewShowcaseAutomation.context.TestContext;
import interviewShowcaseAutomation.factory.PageFactoryManager;
import interviewShowcaseAutomation.pages.UsersPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.junit.Assert;

public class UserLisUIStepDefinitions {
    private final UsersPage usersPage;
    private final TestContext context;


    public UserLisUIStepDefinitions(TestContext context) {
        this.context = context;
        usersPage = PageFactoryManager.getUsersPage(context.driver);
    }

    @When("I navigate to Users page")
    public void iNavigateToUsersPage() {
        usersPage.load(EndPoint.USERSLIST.url);
    }

    @Then("I compare the API data with UI data")
    public void iCompareTheAPIDataWithUIData() {
        JSONObject prodData = new JSONObject(usersPage.getProductData());

        Assert.assertEquals(context.getUsersList.getPage(), prodData.get("page"));
        Assert.assertEquals(context.getUsersList.getPer_page(), prodData.get("per_page"));
        Assert.assertEquals(context.getUsersList.getTotal(), prodData.get("total"));
        Assert.assertEquals(context.getUsersList.getTotal_pages(), prodData.get("total_pages"));
        Assert.assertEquals(context.getUsersList.getData().size(), prodData.getJSONArray("data").length());
        for (int i=0 ; i != prodData.getJSONArray("data").length(); i++){
            JSONObject data = new JSONObject(prodData.getJSONArray("data").get(i).toString());
            Assert.assertEquals(context.getUsersList.getData().get(i).getAvatar(), data.get("avatar"));
            Assert.assertEquals(context.getUsersList.getData().get(i).getEmail(), data.get("email"));
            Assert.assertEquals(context.getUsersList.getData().get(i).getFirst_name(), data.get("first_name"));
            Assert.assertEquals(context.getUsersList.getData().get(i).getLast_name(), data.get("last_name"));
            Assert.assertEquals(context.getUsersList.getData().get(i).getId(), data.get("id"));
        }
        Assert.assertEquals(context.getUsersList.getSupport().getUrl(),prodData.getJSONObject("support").get("url"));
        Assert.assertEquals(context.getUsersList.getSupport().getText(), prodData.getJSONObject("support").get("text"));

    }
}
