package interviewShowcaseAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UKSearchPage extends BasePage{
    public UKSearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Check if you need a UK visa']") private WebElement searchResult;

    @FindBy(id = "search-main") private WebElement searchBox;
    @FindBy(xpath = "//div[@id='wrapper']//button") private WebElement searchButton;

    public String captureSearchResult(){
        return wait.until(ExpectedConditions.visibilityOf(searchResult)).getText();
    }

    public void enterSearchText(String text){
        wait.until(ExpectedConditions.visibilityOf(searchBox)).clear();
        searchBox.sendKeys(text);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public void performSearch(){
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
}
