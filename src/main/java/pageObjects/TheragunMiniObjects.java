package pageObjects;

import base.Setup;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TheragunMiniObjects extends Setup {

    public TheragunMiniObjects(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    //@iOSXCUITFindBy(xpath = "XCUIElementTypeStaticText[@name=\"Generation 1\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"mini\"])[2]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Generation 1']")
    public WebElement miniGeneration1;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONTINUE\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='CONTINUE']")
    public WebElement continueBTN;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"GET STARTED\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='GET STARTED']")
    public WebElement getStartedBTN;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Theragun mini\"])[2]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Theragun mini']")
    public WebElement theragunMiniDevice;
}
