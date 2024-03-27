package pageObjects;

import base.Setup;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddDeviceObjects extends Setup {
    public AddDeviceObjects(){

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Theragun']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Theragun']")
    public WebElement theragun;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='%s']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='%s']")
    public WebElement theragunDevice;

    public WebElement getTheragunDevice(String name) {
        if(platform_param.equalsIgnoreCase("iOS")) {
            String xpath = String.format("XCUIElementTypeStaticText[@name='%s']", name);
            theragunDevice = driver.findElement(By.xpath(xpath));
        }
        else {
            String xpath = String.format("//android.widget.TextView[@text='%s']", name);
            theragunDevice = driver.findElement(By.xpath(xpath));
        }
        return theragunDevice;
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PRO Plus\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PRO Plus']")
    public WebElement proPlus;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ENABLE BLUETOOTH\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='ENABLE BLUETOOTH']")
    public WebElement enableBluetooth;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"PAIR DEVICE\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='PAIR DEVICE']")
    public WebElement pairDevice;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Prime\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Prime']")
    public WebElement pairPrime;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PRO Plus\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PRO Plus']")
    public WebElement pairProPlus;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SKIP\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SKIP']")
    public WebElement skipDeviceOnboarding;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"UIA.Therabody.NotificationPermission.PermissionButton\"]")
    public WebElement enableNotification;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Therabody\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='3']")
    public WebElement deviceDropDown;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Theragun Prime\"])[2]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")
    public WebElement pairedDevicePrime;

    //@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Bluetooth\"]")
    @iOSXCUITFindBy(accessibility = "Bluetooth")
    public WebElement bluetoothTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Bluetooth\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='TURN ON']")
    public WebElement bluetoothBtn;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Theragun PRO Plus\"])[2]")
    public WebElement getPairedDeviceProPlus;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"UIA.Therabody.DeviceManager.AddNewDeviceButton\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='ADD NEW DEVICE']")
    public WebElement addNewDevice;
}
