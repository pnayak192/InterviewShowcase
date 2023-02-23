package interviewShowcaseAutomation.stepdefinations.UIStepDefs;

import interviewShowcaseAutomation.constants.EndPoint;
import interviewShowcaseAutomation.context.TestContext;
import interviewShowcaseAutomation.factory.PageFactoryManager;
import interviewShowcaseAutomation.pages.UKHomePage;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class UKHomeStepdefs {

    private final UKHomePage homePage;
    private final TestContext context;

    public UKHomeStepdefs(TestContext context){
        this.context = context;
        homePage = PageFactoryManager.getUKHomePage(context.driver);
    }

    @Given("I'm on the UKHome Page")
    public void iMOnTheUKHomePage() {
        homePage.load(EndPoint.HOME.url);
        Assert.assertEquals("Welcome to GOV.UK", homePage.getHomePageTitle());
    }


}
