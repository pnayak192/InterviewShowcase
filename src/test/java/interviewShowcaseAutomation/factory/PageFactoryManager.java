package interviewShowcaseAutomation.factory;

import interviewShowcaseAutomation.pages.*;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    private static StorePage storePage;
    private static CartPage cartPage;
    private static CheckoutPage checkoutPage;

    private static InformationPage infoPage;
    private static UsersPage usersPage;

    private static UKHomePage homePage;
    private static UKSearchPage searchPage;

    public static StorePage getStorePage(WebDriver driver){
        return storePage == null ? new StorePage(driver) : storePage;
    }

    public static CartPage getCartPage(WebDriver driver){
        return cartPage == null ? new CartPage(driver) : cartPage;
    }

    public static CheckoutPage getCheckoutPage(WebDriver driver){
        return checkoutPage == null ? new CheckoutPage(driver) : checkoutPage;
    }

    public static InformationPage getInfoPage(WebDriver driver){
        return infoPage == null ? new InformationPage(driver) : infoPage;
    }

    public static UKHomePage getUKHomePage(WebDriver driver){
        return homePage == null ? new UKHomePage(driver) : homePage;
    }

    public static UKSearchPage getUKSearchPage(WebDriver driver){
        return searchPage == null ? new UKSearchPage(driver) : searchPage;
    }

    public static UsersPage getUsersPage(WebDriver driver){
        return usersPage == null ? new UsersPage(driver) : usersPage;
    }
}
