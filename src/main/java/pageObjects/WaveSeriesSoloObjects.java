package pageObjects;

import base.Setup;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WaveSeriesSoloObjects extends Setup {

    public WaveSeriesSoloObjects(){

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
//============================================== ROUTINE OVERVIEW SCREEN ELEMENTS ========================================================

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Run Warm-Up\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Run Warm-Up']")
    public WebElement routineName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Marathon Warmup\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='7 min']")
    public WebElement routineTime;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Therabody\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeButton")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Save']")
    public WebElement saveBTN;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Preferences\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Preferences']")
    public WebElement preferencesBTN;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Prepare your feet, calves, quads, hamstrings, and glutes for your best run yet. Use your device to activate your muscles and reduce post-running soreness. \"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Prepare your feet, calves, quads, hamstrings, and glutes for your best run yet. Use your device to activate your muscles and reduce post-running soreness. ']")
    public WebElement preferencesDescription;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Body parts\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Body parts']")
    public WebElement bodyPartTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Feet, Shins, Calves, Hamstrings, Quads, Glutes\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Feet, Shins, Calves, Hamstrings, Quads, Glutes']")
    public WebElement bodyPartDetails;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Therabody\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView")
    public WebElement bodyPartImage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Stretches: Hamstrings\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stretches: Hamstrings']")
    public WebElement stretches;
//============================================== ROUTINE SCREEN ELEMENTS ========================================================
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"START ROUTINE\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='START ROUTINE']")
    public WebElement startRoutine;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"ic_player_previous\"]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView[1]")
    public WebElement previousBTN;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"ic_player_next\"]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView[2]")
    public WebElement nextBTN;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ic pause blackgrey\"]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.ImageView")
    public WebElement pauseBTN;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ic close player\"]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView")
    public WebElement closeBTN;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"1/14\"]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[2]")
    public WebElement routineStep1;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"2/14\"]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[2]")
    public WebElement routineStep2;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"8/14\"]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[2]")
    public WebElement routineStep8;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"END ROUTINE\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='END ROUTINE']")
    public WebElement endRoutine;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Stretching\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stretching']")
    public WebElement stretchingStep;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Breaks\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Breaks']")
    public WebElement breaks;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"switch off\"]")
    //@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.CheckBox")
    @AndroidFindBy(xpath = "//android.widget.CheckBox")
    public WebElement setBreakPeriodToggle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"arrowLeft\"]")
    //@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView[1]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView")
    public WebElement backBTN;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Starting in')]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View[1]")
    public WebElement breakTime;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"switch off\"]")
   // @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[3]/android.view.ViewGroup/android.widget.CheckBox")
    @AndroidFindBy(xpath = "//android.widget.CheckBox")
    public WebElement stretchingToggle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Right Hamstring\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Right Hamstring']")
    public WebElement step7;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\" \"]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView[2]")
    public WebElement settingsIcon;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"1.0.1 • Your device is up to date\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='1.0.1 • Your device is up to date']")
    public WebElement firmwareText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ic backArrowShadow\"]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ImageView[3]")
    public WebElement backToHomepage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"arrowLeft\"]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView")
    public WebElement backToDeviceManager;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"UIA.Therabody.DeviceManager.CloseButton\"]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    public WebElement closeDeviceManager;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Added to Saved\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Added to Saved\"]")
    public WebElement savedTooltip;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"UIA.Therabody.TabBar.SavedTab\"]")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Saved\"]/android.widget.FrameLayout/android.widget.ImageView")
    public WebElement savedTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"UIA.Therabody.TabBar.HomeTab\"]")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Home\"]/android.widget.FrameLayout/android.widget.ImageView")
    public WebElement homeTab;


    //============================================== SAVED TAB ELEMENTS ========================================================
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ic more options\"]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.ImageView[2]")
    public WebElement moreOptions;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"View Routine\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='View Routine']")
    public WebElement viewRoutine;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Save\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Save']")
    public WebElement routineCompleteSave;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Saved\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Saved']")
    public WebElement routineCompleteSaved;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"REMOVE\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='REMOVE']")
    public WebElement routineCompleteRemoveSaved;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Removed %s from Saved.']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Removed %s from Saved.']")
    public WebElement removedFromSavedToast;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"DONE\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='DONE']")
    public WebElement routineCompleteDone;

    // Method to set the 'name' parameter in the XPath
    public WebElement getRemovedFromSavedToast(String name) {
        if(platform_param.equalsIgnoreCase("iOS")) {
            String xpath = String.format("//XCUIElementTypeStaticText[@name='Removed %s from Saved.']", name);
            removedFromSavedToast = driver.findElement(By.xpath(xpath));
        }
        else {
            String xpath = String.format("//android.widget.TextView[@text='Removed %s from Saved.']", name);
            removedFromSavedToast = driver.findElement(By.xpath(xpath));
        }
        return removedFromSavedToast;
    }

}
