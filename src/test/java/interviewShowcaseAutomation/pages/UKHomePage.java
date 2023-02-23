package interviewShowcaseAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UKHomePage extends BasePage{
    @FindBy(css = ".homepage-inverse-header__title") private WebElement pageTitle;
    @FindBy(xpath = "//input[@id='search-main-a0cc3295']") private WebElement searchBox;
    @FindBy(xpath = "//button[normalize-space()='Search GOV.UK']") private WebElement getSearchButton;


    public UKHomePage(WebDriver driver) {
        super(driver);
    }

    public String getHomePageTitle(){
        return wait.until(ExpectedConditions.visibilityOf(pageTitle)).getText();
    }


}
