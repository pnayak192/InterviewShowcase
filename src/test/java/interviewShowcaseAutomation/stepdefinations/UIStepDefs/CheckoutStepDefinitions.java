package interviewShowcaseAutomation.stepdefinations.UIStepDefs;

import interviewShowcaseAutomation.constants.EndPoint;
import interviewShowcaseAutomation.context.TestContext;
import interviewShowcaseAutomation.pages.CheckoutPage;
import interviewShowcaseAutomation.factory.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckoutStepDefinitions {
    private final TestContext context;
    private final CheckoutPage checkoutPage;

    public CheckoutStepDefinitions(TestContext context){
        this.context = context;
        checkoutPage = PageFactoryManager.getCheckoutPage(context.driver);
    }

    @When("I provide billing details")
    public void iProvideBillingDetails() {
        checkoutPage.setBillingDetails(context.billingDetails);
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        checkoutPage.placeOrder();
    }

//    @Then("the order should be placed successfully")
//    public void theOrderShouldBePlacedSuccessfully() {
//        Assert.assertEquals("Thank you. Your order has been received.", checkoutPage.getNotice());
//    }

    @And("I'm on the Checkout page")
    public void iMOnTheCheckoutPage() {
        checkoutPage.load(EndPoint.CHECKOUT.url);
    }


    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals("Thank you. Your order has been received.", checkoutPage.getNotice());
    }
}
