package pageObjects;

import base.Setup;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OnboardingFlowObjects extends Setup {

    public OnboardingFlowObjects(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\\'%s Tutorials Completed\\']")
    public WebElement cardHeader;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='START TUTORIAL']")
    public WebElement startTutorialBTN;

    public WebElement getCardHeader(String count) {

            String xpath = String.format("//android.widget.TextView[@text='%s Tutorials Completed']", count);
        cardHeader = driver.findElement(By.xpath(xpath));
        return cardHeader;
    }
}
