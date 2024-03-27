package pageObjects;

import base.Setup;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WaveSeriesOtherRollerObjects extends Setup {

    public WaveSeriesOtherRollerObjects(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Wave Series\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Wave Series']")
    public WebElement waveSeriesCategory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Other Roller\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Other']")
    public WebElement otherRoller;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Other Roller\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Other Roller']")
    public WebElement pairedOtherRoller;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Run Recovery\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Run Recovery']")
    public WebElement recoveryRoutine;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Bluetooth Mode\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bluetooth Mode']")
    public WebElement bluetoothMode;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Routine mode preference is only available when connecting to a Bluetooth enabled Therabody device.\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Routine mode preference is only available when connecting to a Bluetooth enabled Therabody device.']")
    public WebElement notConnectedText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"UIA.Therabody.TabBar.ProfileTab\"]")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Profile\"]/android.widget.FrameLayout/android.widget.ImageView")
    public WebElement profileTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Routine preferences\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Routine preferences']")
    public WebElement profileRoutinePreference;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Therabody\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeImage")
    public WebElement expandController;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TIP\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='TIP']")
    public WebElement tipHeader;

}
