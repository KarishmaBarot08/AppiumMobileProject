package pageFunctions;

import base.Setup;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.AddDeviceObjects;
import pageObjects.PrimeDeviceObjects;
import pageObjects.TheragunMiniObjects;
import pageObjects.WaveSeriesSoloObjects;
import utilities.UtilityMethods;

import java.time.Duration;
import java.util.List;

public class TheragunMiniFunctions extends Setup {
    public TheragunMiniObjects miniObjects;
    public AddDeviceObjects addDeviceObjects;
    public WaveSeriesSoloFunctions waveSeriesSoloFunctions;
    public WaveSeriesSoloObjects waveSeriesSoloObjects;
    public PrimeDeviceObjects primeObj;

    public TheragunMiniFunctions(){
        miniObjects = new TheragunMiniObjects();
        addDeviceObjects = new AddDeviceObjects();
        waveSeriesSoloFunctions = new WaveSeriesSoloFunctions();
        waveSeriesSoloObjects = new WaveSeriesSoloObjects();
        primeObj = new PrimeDeviceObjects();
    }

    public void pairMiniGeneration1(){
        waitForElementClickAbility(addDeviceObjects.theragun);
        if(platform_param.equalsIgnoreCase("iOS")){
            //By device = MobileBy.xpath("XCUIElementTypeStaticText[@name=\"Generation 1\"]");

            TouchAction action =new TouchAction((PerformsTouchActions) driver);
            Dimension size	=driver.manage().window().getSize();
            int width=size.width;
            int height=size.height;
            int middleOfX=width/2;
            int startYCoordinate= (int)(height*.8);
            int endYCoordinate= (int)(height*.2);

            action.press(PointOption.point(middleOfX, startYCoordinate))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
            action_clickOnPosition(197,466);
        }else{
            driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Generation 1" + "\").instance(0))"));
            waitForElementClickAbility(miniObjects.miniGeneration1);
        }



        waitForElementClickAbility(miniObjects.continueBTN);
        waitForElementClickAbility(miniObjects.continueBTN);
        waitForElementClickAbility(miniObjects.getStartedBTN);
        if(platform_param.equalsIgnoreCase("iOS")){
            waitForElementClickAbility(addDeviceObjects.enableNotification);
            acceptAlert();
        }

    }
    public void verifyPairedDevice(){
        waitForElementClickAbility(addDeviceObjects.deviceDropDown);
        waitForElementVisibility(miniObjects.theragunMiniDevice);
        String pairedDevice = miniObjects.theragunMiniDevice.getText();
        System.out.println("Fetched device name is: " + pairedDevice);
        log.info("Fetched device name is: " + pairedDevice);
        Assert.assertTrue(pairedDevice.contains("Theragun mini"));
        waitForElementClickAbility(waveSeriesSoloObjects.closeDeviceManager);
    }

   //testing purpose
   public void toggle() throws InterruptedException {
        waitForElementClickAbility(primeObj.routineName);
        Point prePoint = getCenterCoordinates(waveSeriesSoloObjects.preferencesBTN);
        action_clickOnPosition(prePoint.getX(), prePoint.getY());
        waitForElementVisibility(waveSeriesSoloObjects.stretchingToggle);
        utilityMethods.toggleSwitchIfOn(waveSeriesSoloObjects.stretchingToggle);
        System.out.println("Stretching toggle turned ON");
        Thread.sleep(3000);
        utilityMethods.toggleSwitchIfOff(waveSeriesSoloObjects.stretchingToggle);
        System.out.println("Stretching toggle turned OFF");
        Thread.sleep(3000);
        utilityMethods.toggleSwitchIfOn(waveSeriesSoloObjects.stretchingToggle);
        System.out.println("Stretching toggle turned ON");
    }
}
