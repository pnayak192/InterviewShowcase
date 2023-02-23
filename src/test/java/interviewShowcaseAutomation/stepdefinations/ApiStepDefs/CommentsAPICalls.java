package interviewShowcaseAutomation.stepdefinations.ApiStepDefs;

import interviewShowcaseAutomation.apis.CommentsAPI;
import interviewShowcaseAutomation.context.TestContext;
import io.cucumber.java.en.Given;

public class CommentsAPICalls {
//    CommentsAPI commentsAPI;
    private final TestContext context;

    public CommentsAPICalls(TestContext context){
        this.context = context;
    }
    @Given("I make a request to comments Api and Capture the data")
    public void makeARequestToApi()
    {
        new CommentsAPI(context);
    }

}
