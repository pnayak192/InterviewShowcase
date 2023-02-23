package interviewShowcaseAutomation.stepdefinations.UIStepDefs;

import interviewShowcaseAutomation.context.TestContext;
import interviewShowcaseAutomation.domainobjects.Product;
import interviewShowcaseAutomation.pages.CartPage;
import interviewShowcaseAutomation.factory.PageFactoryManager;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CartStepDefinitions {
    private final CartPage cartPage;

    public CartStepDefinitions(TestContext context){
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }

    @Then("I should see {int} {product} in the cart")
    public void iShouldSeeInTheCart(int quantity, Product product) {
        Assert.assertEquals(product.getName(), cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }
}
