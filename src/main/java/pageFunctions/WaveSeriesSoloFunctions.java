package pageFunctions;

import base.Setup;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.AddDeviceObjects;
import pageObjects.PrimeDeviceObjects;
import pageObjects.WaveSeriesSoloObjects;
import utilities.UtilityMethods;

import java.time.Duration;
import java.util.List;


public class WaveSeriesSoloFunctions extends Setup {

    private AddDeviceObjects deviceObject;
    private WaveSeriesSoloObjects waveSeriesSoloObject;
    private PrimeDeviceObjects primeDeviceObjects;
    public static Logger log = LogManager.getLogger(WaveSeriesSoloFunctions.class);
    public String routinename = "Run Warm-Up";


    public WaveSeriesSoloFunctions() {
        deviceObject = new AddDeviceObjects();
        waveSeriesSoloObject = new WaveSeriesSoloObjects();
    }

    /*Pre-requisites:
    1. Wave Series Solo device should be already paired.
    2.Solo device should be ON.
    3. Breaks option should be OFF in preferences settings.
    4. Stretching exercises option should be turned ON in preferences settings.*/
    //Verify Home screen loaded with content
    public void verifyPairedDevice() {
        if (platform_param.equalsIgnoreCase("iOS")) {
            waitForElementVisibility(deviceObject.enableNotification);
            if (deviceObject.enableNotification.isDisplayed()) {
                deviceObject.enableNotification.click();
                driver.switchTo().alert().accept();
            }
        }
        Assert.assertTrue(deviceObject.deviceDropDown.isDisplayed());
        System.out.println("Home screen opened and Wave series Solo device is paired");
        log.info("Home screen opened and Wave series Solo device is paired");
    }

    //Selecting routine and navigation to its overview screen
    public void selectRoutine() throws InterruptedException {

        if (platform_param.equalsIgnoreCase("iOS")) {
            By routine = MobileBy.xpath("//XCUIElementTypeStaticText[@name=\"Run Warm-Up\"]");
            scrollForMobile(routine);
            waveSeriesSoloObject.routineName.click();
            acceptAlert();
        } else {
            driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Run Warm-Up" + "\").instance(0))"));
            waveSeriesSoloObject.routineName.click();
        }
        Assert.assertEquals(waveSeriesSoloObject.routineName.getText(), "Run Warm-Up");
        System.out.println("Routine - Run Warm-Up overview screen opened!!!");
        log.info("Routine - Run Warm-Up overview screen opened!!!");
    }

    //Scenario 2: Verifying all expected elements are displayed on Routine overview screen
    public void routineElements() {
        Assert.assertTrue(waveSeriesSoloObject.routineName.isDisplayed(), "Routine name not displayed!");
        System.out.println("Routine name: " + waveSeriesSoloObject.routineName.getText() + " is displayed!!");
        log.info("Routine name: " + waveSeriesSoloObject.routineName.getText() + " is displayed!!");
        Assert.assertTrue(waveSeriesSoloObject.routineTime.isEnabled(), "Routine time not displayed!");
        System.out.println("Routine time: " + waveSeriesSoloObject.routineTime.getText() + " is displayed!!");
        log.info("Routine time: " + waveSeriesSoloObject.routineTime.getText() + " is displayed!!");
        Assert.assertTrue(waveSeriesSoloObject.saveBTN.isEnabled(), "Save button not displayed!");

        System.out.println("Save Button at top right is displayed!!");
        log.info("Save Button at top right is displayed!!");
        Assert.assertTrue(waveSeriesSoloObject.preferencesBTN.isEnabled(), "Preferences button is not displayed!");
        System.out.println("Preferences Button is displayed!!");
        log.info("Preferences Button is displayed!!");
        Assert.assertTrue(waveSeriesSoloObject.preferencesDescription.isDisplayed(), "Preferences details not displayed!");
        System.out.println("Description under preference is: " + waveSeriesSoloObject.preferencesDescription.getText());
        log.info("Description under preference is: " + waveSeriesSoloObject.preferencesDescription.getText());
        Assert.assertTrue(waveSeriesSoloObject.bodyPartTitle.isDisplayed(), "Body part title not displayed!");
        System.out.println("Body parts described on screen: " + waveSeriesSoloObject.bodyPartDetails.getText());
        log.info("Body parts described on screen: " + waveSeriesSoloObject.bodyPartDetails.getText());
        Assert.assertTrue(waveSeriesSoloObject.bodyPartImage.isDisplayed(), "Body part image not displayed!");
        System.out.println("Body part Image is displayed!!!");
        log.info("Body part Image is displayed!!!");
        Assert.assertTrue(waveSeriesSoloObject.stretches.isDisplayed(), "Stretching step not displayed!");
        System.out.println("Stretching step available: " + waveSeriesSoloObject.stretches.getText());
        log.info("Stretching step available: " + waveSeriesSoloObject.stretches.getText());
    }

    // Scenario 3: Verifying Stretching step is mentioned on Routine overview screen
    public void stretchingStep() {
        Point prePoint = getCenterCoordinates(waveSeriesSoloObject.preferencesBTN);
        action_clickOnPosition(prePoint.getX(), prePoint.getY());
        //waitForElementClickAbility(waveSeriesSoloObject.preferencesBTN);
        waitForElementVisibility(waveSeriesSoloObject.stretchingToggle);
        waitForElementClickAbility(waveSeriesSoloObject.stretchingToggle);
        //clickElementWithRetry(waveSeriesSoloObject.stretchingToggle);
        waitForElementClickAbility(waveSeriesSoloObject.backBTN);
        Assert.assertTrue(waveSeriesSoloObject.stretches.getText().contains(":"), "Stretching step bodypart not found!!");
        String bodyPart = waveSeriesSoloObject.stretches.getText().split(":")[1];
        System.out.println("Stretching step contains bodypart --> " + bodyPart);
        log.info("Stretching step contains bodypart --> " + bodyPart);
    }

    //Scenario 4: Start routine, interact with next, previous, pause, close CTAs
    public void routinePlayerBehaviour() throws InterruptedException {
        //waitForElementVisibility(waveSeriesSoloObject.startRoutine);
        try {
            WebElement buttonElement;
            if (platform_param.equalsIgnoreCase("iOS")) {
                buttonElement = new WebDriverWait(driver, Duration.ofSeconds(30))
                        .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//XCUIElementTypeButton")))
                        .get(0);
            } else {
                buttonElement = new WebDriverWait(driver, Duration.ofSeconds(30))
                        .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button")))
                        .get(2);
            }
            // Get the text of the button
            String buttonText = buttonElement.getAttribute("name");
            System.out.println("Button status: " + buttonText);

            // Check the state of the device
            if (!(buttonText.equals("START ROUTINE"))) {
                // Device is OFF
                System.out.println("Device is OFF. Please turn it ON. System will wait for 15 seconds!");
                log.info("Device is OFF. Please turn it ON. System will wait for 15 seconds!");
                Thread.sleep(15000);
            }
            waveSeriesSoloObject.startRoutine.click();

        } catch (Exception e) {
            System.out.println("System waited for device to be turned ON, but didn't get so!");
            log.info("System waited for device to be turned ON, but didn't get so!");
        }

        Thread.sleep(5000);
        Assert.assertTrue(waveSeriesSoloObject.pauseBTN.isEnabled(), "Pause button is not enabled!");
        Assert.assertTrue(waveSeriesSoloObject.routineStep1.isDisplayed(), "Routine step 1/14 title not displayed!");

        Point centrePointNEXT = getCenterCoordinates(waveSeriesSoloObject.nextBTN);

        action_clickOnPosition(centrePointNEXT.getX(), centrePointNEXT.getY());

        Thread.sleep(2000);
        Assert.assertTrue(waveSeriesSoloObject.routineStep2.isDisplayed(), "Routine step 2/14 title not displayed!");
        System.out.println("Next button clicked...Next step played!");
        log.info("Next button clicked...Next step played!");
        Thread.sleep(4000);

        Point centrePointPREVIOUS = getCenterCoordinates(waveSeriesSoloObject.previousBTN);
        action_clickOnPosition(centrePointPREVIOUS.getX(), centrePointPREVIOUS.getY());
        Assert.assertTrue(waveSeriesSoloObject.routineStep1.isDisplayed(), "Routine step 1/14 title not displayed!");
        System.out.println("Previous button clicked...Previous step played!");
        log.info("Previous button clicked...Previous step played!");
        Thread.sleep(3000);

        waveSeriesSoloObject.pauseBTN.click();
        System.out.println("Routine playing stopped!!");
        log.info("Routine playing stopped!!");
        Thread.sleep(3000);

        waveSeriesSoloObject.closeBTN.click();
        waitForElementClickAbility(waveSeriesSoloObject.endRoutine);
        System.out.println("Routine overview screen closed!!");
        log.info("Routine overview screen closed!!");
    }

    //Scenario 5.1: Start routine, reach to the Stretching step, wait until stretching step finishes, then resume playing
    public void routineStepStretching() throws InterruptedException {
        waitForElementVisibility(waveSeriesSoloObject.startRoutine);
        String buttonText = waveSeriesSoloObject.startRoutine.getText();

        if (!(buttonText.equals("START ROUTINE"))) {
            System.out.println("Please turn on device. Make sure device is turned on and connected before running routine!");
            log.info("Please turn on device. Make sure device is turned on and connected before running routine!");
        }
        waveSeriesSoloObject.startRoutine.click();

        Point centrePointNEXT = getCenterCoordinates(waveSeriesSoloObject.nextBTN);
        for (int i = 0; i < 6; i++) {
            Thread.sleep(3000);
            action_clickOnPosition(centrePointNEXT.getX(), centrePointNEXT.getY());
        }
        Assert.assertTrue(waveSeriesSoloObject.stretchingStep.isDisplayed());
        System.out.println("Stretching step is displayed!");
        log.info("Stretching step is displayed!");
        Thread.sleep(30000);
        waveSeriesSoloObject.pauseBTN.click();
        Assert.assertTrue(waveSeriesSoloObject.routineStep8.isDisplayed(), "Routine step 8/14 title not displayed!");
        System.out.println("Resumed once stretching step finished...Next step played!");
        log.info("Resumed once stretching step finished...Next step played!");
        Thread.sleep(3000);

        waveSeriesSoloObject.closeBTN.click();
        waitForElementClickAbility(waveSeriesSoloObject.endRoutine);
        System.out.println("Routine overview screen closed!!");
        log.info("Routine overview screen closed!!");

    }

    //Scenario 6: Toggle off stretching step from preferences, play routine and verify stretching step is not displayed
    public void removeStretchingStep() throws InterruptedException {
        Point prePoint = getCenterCoordinates(waveSeriesSoloObject.preferencesBTN);
        action_clickOnPosition(prePoint.getX(), prePoint.getY());
        //waitForElementClickAbility(waveSeriesSoloObject.preferencesBTN);
        waitForElementVisibility(waveSeriesSoloObject.stretchingToggle);
        waitForElementClickAbility(waveSeriesSoloObject.stretchingToggle);
        //clickElementWithRetry(waveSeriesSoloObject.stretchingToggle);
        waitForElementClickAbility(waveSeriesSoloObject.backBTN);
        waitForElementVisibility(waveSeriesSoloObject.startRoutine);
        String buttonText = waveSeriesSoloObject.startRoutine.getText();

        if (!(buttonText.equals("START ROUTINE"))) {
            System.out.println("Please turn on device. Make sure device is turned on and connected before running routine!");
            log.info("Please turn on device. Make sure device is turned on and connected before running routine!");
        }
        waveSeriesSoloObject.startRoutine.click();
        Point centrePointNEXT = getCenterCoordinates(waveSeriesSoloObject.nextBTN);
        for (int i = 0; i < 6; i++) {
            Thread.sleep(3000);
            action_clickOnPosition(centrePointNEXT.getX(), centrePointNEXT.getY());
        }
        Assert.assertFalse(waveSeriesSoloObject.step7.getText().contains("Stretching"));
        System.out.println("Stretching step not displayed!!");
        log.info("Stretching step not displayed!!");
        Thread.sleep(3000);

        waveSeriesSoloObject.closeBTN.click();
        waitForElementClickAbility(waveSeriesSoloObject.endRoutine);
        System.out.println("Routine overview screen closed!!");
        log.info("Routine overview screen closed!!");
    }

    //Scenario 5.2: Toggle ON break from preferences, play routine and verify break time appears between routine steps
    public void addBreak() throws InterruptedException {
        //waitForElementClickAbility(waveSeriesSoloObject.preferencesBTN);
        Point prePoint = getCenterCoordinates(waveSeriesSoloObject.preferencesBTN);
        action_clickOnPosition(prePoint.getX(), prePoint.getY());

        clickElementWithRetry(waveSeriesSoloObject.breaks);
        waitForElementVisibility(waveSeriesSoloObject.setBreakPeriodToggle);
        //utilityMethods.toggleSwitchIfOn(waveSeriesSoloObject.setBreakPeriodToggle);
       clickElementWithRetry(waveSeriesSoloObject.setBreakPeriodToggle);


        //waitForElementClickAbility(waveSeriesSoloObject.setBreakPeriodToggle);
        waitForElementClickAbility(waveSeriesSoloObject.backBTN);
        waitForElementClickAbility(waveSeriesSoloObject.backBTN);
        waitForElementVisibility(waveSeriesSoloObject.startRoutine);
        String buttonText = waveSeriesSoloObject.startRoutine.getText();

        if (!(buttonText.equals("START ROUTINE"))) {
            System.out.println("Please turn on device. Make sure device is turned on and connected before running routine!");
            log.info("Please turn on device. Make sure device is turned on and connected before running routine!");
        }
        waveSeriesSoloObject.startRoutine.click();
        Thread.sleep(35000);
        if (platform_param.equalsIgnoreCase("iOS")) {
            Assert.assertTrue(waveSeriesSoloObject.breakTime.getText().contains("Starting in"));
        }
        System.out.println("Break time is being displayed between routine steps");
        log.info("Break time is being displayed between routine steps");
        Thread.sleep(3000);
        waveSeriesSoloObject.closeBTN.click();
        waitForElementClickAbility(waveSeriesSoloObject.endRoutine);
        System.out.println("Routine player ended... Routine overview screen is here!");
        log.info("Routine player ended... Routine overview screen is here!");
        Point prefPoint = getCenterCoordinates(waveSeriesSoloObject.preferencesBTN);
        action_clickOnPosition(prefPoint.getX(),prefPoint.getY());
        //waitForElementClickAbility(waveSeriesSoloObject.preferencesBTN);
        clickElementWithRetry(waveSeriesSoloObject.breaks);

       // utilityMethods.toggleSwitchIfOff(waveSeriesSoloObject.setBreakPeriodToggle);
        clickElementWithRetry(waveSeriesSoloObject.setBreakPeriodToggle);
        waitForElementClickAbility(waveSeriesSoloObject.backBTN);
        waitForElementClickAbility(waveSeriesSoloObject.backBTN);
        waitForElementClickAbility(waveSeriesSoloObject.backToHomepage);
        System.out.println("Welcome back to Homepage");
        log.info("Welcome back to Homepage");
    }

    //Scenario 7: Save routine from routine overview screen, navigate to Saved tab and verify saved routine is listed
    public void saveRoutine() {
        waitForElementClickAbility(waveSeriesSoloObject.saveBTN);
        Assert.assertTrue(waveSeriesSoloObject.savedTooltip.isDisplayed());
        System.out.println("Routine saved!!");
        log.info("Routine saved!!");
        waitForElementClickAbility(waveSeriesSoloObject.backToHomepage);
        waitForElementClickAbility(waveSeriesSoloObject.savedTab);
        Assert.assertTrue(waveSeriesSoloObject.routineName.isDisplayed()); //WaveSeries Solo device
        System.out.println(waveSeriesSoloObject.routineName.getText() +" routine is present on Saved tab");
        log.info(waveSeriesSoloObject.routineName.getText() +" routine is present on Saved tab");
    }

    public void playSavedRoutineAndUnsaveOnRoutineCompletion() throws InterruptedException {
        waitForElementClickAbility(waveSeriesSoloObject.moreOptions);
        Point centrePoint = getCenterCoordinates(waveSeriesSoloObject.viewRoutine);
        action_clickOnPosition(centrePoint.getX(),centrePoint.getY());
        //waitForElementClickAbility(waveSeriesSoloObject.preferencesBTN);
        Point prePoint = getCenterCoordinates(waveSeriesSoloObject.preferencesBTN);
        action_clickOnPosition(prePoint.getX(), prePoint.getY());
        clickElementWithRetry(waveSeriesSoloObject.breaks);
        utilityMethods.toggleSwitchIfOff(waveSeriesSoloObject.setBreakPeriodToggle);
        waitForElementClickAbility(waveSeriesSoloObject.backBTN);
        waitForElementClickAbility(waveSeriesSoloObject.backBTN);
        waitForElementClickAbility(waveSeriesSoloObject.startRoutine);
        Point nextBTN = getCenterCoordinates(waveSeriesSoloObject.nextBTN);
        for(int i=0;i<12;i++){
            Thread.sleep(3000);
            action_clickOnPosition(nextBTN.getX(), nextBTN.getY());
        }
        Assert.assertTrue(waveSeriesSoloObject.routineCompleteRemoveSaved.isEnabled());
        waitForElementClickAbility(waveSeriesSoloObject.routineCompleteRemoveSaved);
        Assert.assertTrue(waveSeriesSoloObject.getRemovedFromSavedToast(routinename ).isDisplayed());
        System.out.println("Removed saved routine from Routine Completion screen");
        log.info("Removed saved routine from Routine Completion screen");
    }

    //Scenario 10: Navigate to device manager --> edit device screen and verify firmware version is listed
    public void checkFirmware() {
        waitForElementClickAbility(waveSeriesSoloObject.homeTab);
        System.out.println("Welcome back to Home screen!");
        log.info("Welcome back to Home screen!");
        if (platform_param.equalsIgnoreCase("Android")) {

            driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToBeginning(10)"));

        }
        waitForElementClickAbility(deviceObject.deviceDropDown);
        if (platform_param.equalsIgnoreCase("Android")) {
            Point centerPoint = getCenterCoordinates(waveSeriesSoloObject.settingsIcon);
            action_clickOnPosition(centerPoint.getX(), centerPoint.getY());
        } else {
            waitForElementClickAbility(waveSeriesSoloObject.settingsIcon);
        }

        Assert.assertTrue(waveSeriesSoloObject.firmwareText.isDisplayed());
        System.out.println("Firmware info::" + waveSeriesSoloObject.firmwareText.getText());
        log.info("Firmware info::" + waveSeriesSoloObject.firmwareText.getText());
        if (platform_param.equalsIgnoreCase("Android")) {
            Point centerPoint = getCenterCoordinates(waveSeriesSoloObject.backToDeviceManager);
            action_clickOnPosition(centerPoint.getX(), centerPoint.getY());
        } else {
            waitForElementClickAbility(waveSeriesSoloObject.backToDeviceManager);
        }
        if (platform_param.equalsIgnoreCase("Android")) {
            Point centerPoint = getCenterCoordinates(waveSeriesSoloObject.closeDeviceManager);
            action_clickOnPosition(centerPoint.getX(), centerPoint.getY());
        } else {
            waitForElementClickAbility(waveSeriesSoloObject.closeDeviceManager);
        }
        System.out.println("Welcome back to HomeScreen!");
        log.info("Welcome back to HomeScreen!");
    }




    //Re-usable methods
    public void scrollForMobile(By by) {
        String previousPageSource = "";
        while (isElementNotEnabled(by) && isNotEndOfPage(previousPageSource)) {
            previousPageSource = driver.getPageSource();
            performScroll();
            System.out.println("Scrolled. Current Page Source:\n" + driver.getPageSource());
        }
    }

    public void performScroll() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int endX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endY = size.getHeight() / 2;

        if (platform_param.equalsIgnoreCase("Android")) {
            performScrollForAndroid(startX, startY, endX, endY);
        } else {
            performScrollForIOS(startX, startY, endX, endY);
        }
    }

    public void performScrollForAndroid(int startX, int endX, int startY, int endY) {
        new AndroidTouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }

    public void performScrollForIOS(int startX, int endX, int startY, int endY) {
        new IOSTouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }

    public boolean isElementNotEnabled(By by) {
        List<WebElement> elements = driver.findElements(by);
        if (platform_param.equalsIgnoreCase("Android")) {
            return elements.isEmpty();
        }
        if (!elements.isEmpty()) {
            return elements.get(0).getAttribute("visible").equalsIgnoreCase("false");
        }
        return true;
    }

    public boolean isNotEndOfPage(String previousPageSource) {
        return !previousPageSource.equals(driver.getPageSource());
    }

}
