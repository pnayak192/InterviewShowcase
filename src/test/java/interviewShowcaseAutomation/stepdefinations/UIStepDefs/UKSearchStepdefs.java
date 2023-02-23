package interviewShowcaseAutomation.stepdefinations.UIStepDefs;

import interviewShowcaseAutomation.constants.EndPoint;
import interviewShowcaseAutomation.context.TestContext;
import interviewShowcaseAutomation.factory.PageFactoryManager;
import interviewShowcaseAutomation.pages.UKSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.junit.Assert;
import static  org.hamcrest.MatcherAssert.assertThat;
import  static org.hamcrest.Matchers.*;

public class UKSearchStepdefs {

    private final UKSearchPage searchPage;
    private final TestContext context;

    public UKSearchStepdefs(TestContext context){
        this.context = context;
        searchPage = PageFactoryManager.getUKSearchPage(context.driver);
    }

    @And("I navigate to Search Page")
    public void iNavigateToSeacrhPage() {
        searchPage.load(EndPoint.SEARCH.url);
    }
    @When("I search {string}")
    public void iSearch(String text) {
        searchPage.enterSearchText(text);
    }


    @Then("I should see {string} in the result")
    public void iShouldSeeInTheResult(String text) {
        assertThat("Abc", searchPage.captureSearchResult(),containsStringIgnoringCase(text));
        //        Assert.assertEquals("Check if you need a UK visa", searchPage.captureSearchResult());
    }
}
