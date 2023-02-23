package interviewShowcaseAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UsersPage extends BasePage{
    public UsersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//pre[@style='word-wrap: break-word; white-space: pre-wrap;']") private WebElement productInfo;

    public String getProductData(){
        return wait.until(ExpectedConditions.visibilityOf(productInfo)).getText();
    }
}
