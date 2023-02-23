package interviewShowcaseAutomation.stepdefinations.ApiStepDefs;

import interviewShowcaseAutomation.apis.ApiRequest;
import interviewShowcaseAutomation.apis.UsersAPI;
import interviewShowcaseAutomation.context.TestContext;
import interviewShowcaseAutomation.domainobjects.UserDetails;
import interviewShowcaseAutomation.pojoPayloadSerialization.usersAPI.CreateUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UsersAPIStepDefs {
    private final TestContext context;

    public UsersAPIStepDefs(TestContext context) {
        this.context = context;
    }

    @Given("I capture the response from Users API")
    public void iCaptureTheResponseFromUsersAPI() {
        new UsersAPI(context).getUsersList();
    }

    @Then("I should find the user created")
    public void iShouldFindTheUserCreated() {


        Assert.assertEquals(context.createdUser.getJob(), context.userDetails.getJob());
        Assert.assertEquals(context.createdUser.getName(), context.userDetails.getName());
        
    }

    @Given("I provide user details by DataTable")
    public void iProvideUserDetails(UserDetails userDetails) {
        context.userDetails = userDetails;
    }

    @Given("I provide user details by Json present in {string}")
    public void iProvideUserDetailsByJsonPresentIn(String payloadFileName) {
        context.setJsonPayLoadPath(payloadFileName);
    }

    @Then("I verify the Schema of the response with {string}")
    public void iVerifyTheSchemaOfTheResponseWith(String responseSchemaFileName) {
        ApiRequest.validateResponseSchema(responseSchemaFileName, context.response);
    }

    @When("I make a request to users API using JsonPayload")
    public void iMakeARequestToUsersAPI() {
        new UsersAPI(context).createUserUsingJson();
    }

    @When("I make a request to users API using POJO")
    public void iMakeARequestToUsersAPIUsingPOJO() {
        new UsersAPI(context).createUserUsingPojo(new CreateUser(context));
    }
}
