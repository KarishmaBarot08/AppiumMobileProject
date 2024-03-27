package pageObjects;

import base.Setup;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PrimeDeviceObjects extends Setup {

    public PrimeDeviceObjects(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /*@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Full Body Self-Care\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Full Body Self-Care']")
    public WebElement routineName;*/

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Bedtime Ritual\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bedtime Ritual']")
    public WebElement routineName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"DONE\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='DONE']")
    public WebElement routineCompleteDone;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"QUICK START\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='QUICK START']")
    public WebElement quickStart;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ic play\"]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageButton[1]")
    public WebElement start;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"pause\"]")
    public WebElement pause;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, \"ic_battery_status_\")]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView[2]")
    public WebElement batteryPercentage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ic backArrowShadow\"]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ImageView[3]")
    public WebElement backHomePagefromRoutine;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"UIA.Therabody.TabBar.HomeTab\"]")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Home\"]/android.widget.FrameLayout/android.widget.ImageView")
    public WebElement homeTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"arrowLeft\"]")
    public WebElement backFromQuick;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Forget Device\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Forget Device']")
    public WebElement forgetDevice;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"FORGET DEVICE\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='FORGET DEVICE']")
    public WebElement forgetDevicePopupBTN;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Current Device\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Current Device']")
    public WebElement currentDevice;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ic dm search\"]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView[3]")
    public WebElement searchIcon;
}
