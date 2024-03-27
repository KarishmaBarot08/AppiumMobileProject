package pageFunctions;

import base.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.AddDeviceObjects;
import pageObjects.PrimeDeviceObjects;
import pageObjects.WaveSeriesSoloObjects;

import java.time.Duration;

public class PrimeDeviceFunctions extends Setup {

    private PrimeDeviceObjects primeObj;
    private WaveSeriesSoloObjects waveSeriesSoloObject;
    //public String routinename = "Full Body Self-Care";
    public String routinename = "Bedtime Ritual";
    public AddDeviceObjects deviceObjects;
    public PrimeDeviceFunctions(){
        primeObj = new PrimeDeviceObjects();
        waveSeriesSoloObject = new WaveSeriesSoloObjects();
        deviceObjects = new AddDeviceObjects();
    }
    public void openAndSaveRoutine() {
        waitForElementClickAbility(primeObj.routineName);
        waitForElementClickAbility(waveSeriesSoloObject.saveBTN);
        Assert.assertTrue(waveSeriesSoloObject.savedTooltip.isDisplayed());
        System.out.println("Routine saved!!");
        log.info("Routine saved!!");
        waitForElementClickAbility(waveSeriesSoloObject.backToHomepage);
        waitForElementClickAbility(waveSeriesSoloObject.savedTab);
        Assert.assertTrue(primeObj.routineName.isDisplayed()); //Prime device
        System.out.println(primeObj.routineName.getText() +" routine is present on Saved tab");
        log.info(primeObj.routineName.getText() +" routine is present on Saved tab");
        waitForElementClickAbility(primeObj.homeTab);
        System.out.println("Welcome back to Homepage");
        log.info("Welcome back to Homepage");
    }
    public void unSaveRoutineFromRoutineCompletionScreen() throws InterruptedException {
        waitForElementClickAbility(waveSeriesSoloObject.moreOptions);
        Point centrePoint = getCenterCoordinates(waveSeriesSoloObject.viewRoutine);
        action_clickOnPosition(centrePoint.getX(),centrePoint.getY());
        Point prefPoint = getCenterCoordinates(waveSeriesSoloObject.preferencesBTN);
        action_clickOnPosition(prefPoint.getX(),prefPoint.getY());
        //waitForElementClickAbility(waveSeriesSoloObject.preferencesBTN);
        clickElementWithRetry(waveSeriesSoloObject.breaks);
        clickElementWithRetry(waveSeriesSoloObject.setBreakPeriodToggle);
        waitForElementClickAbility(waveSeriesSoloObject.backBTN);
        waitForElementClickAbility(waveSeriesSoloObject.backBTN);
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
            Thread.sleep(3000);
            Point nextBTN = getCenterCoordinates(waveSeriesSoloObject.nextBTN);
            for(int i=0;i<14;i++){
                Thread.sleep(4000);
                action_clickOnPosition(nextBTN.getX(), nextBTN.getY());
            }

        } catch (Exception e) {
            System.out.println("System waited for device to be turned ON, but didn't get so!");
            log.info("System waited for device to be turned ON, but didn't get so!");
        }

        Assert.assertTrue(waveSeriesSoloObject.routineCompleteSave.isEnabled());
        System.out.println("Routine is shown 'saved' on Routine Completion Screen");
        log.info("Routine is shown 'saved' on Routine Completion Screen");
        //waitForElementClickAbility(waveSeriesSoloObject.routineCompleteSave);
        Point savePoint = getCenterCoordinates(waveSeriesSoloObject.routineCompleteSave);
        action_clickOnPosition(savePoint.getX(), savePoint.getY());
        waitForElementClickAbility(waveSeriesSoloObject.routineCompleteRemoveSaved);
        Thread.sleep(1000);
        Assert.assertTrue(waveSeriesSoloObject.getRemovedFromSavedToast(routinename).isEnabled());
        System.out.println("Removed saved routine from Routine Completion screen");
        log.info("Removed saved routine from Routine Completion screen");
        waitForElementClickAbility(primeObj.routineCompleteDone);
        System.out.println("Back to Routine Overview Screen");
        log.info("Back to Routine Overview Screen");
        //waitForElementClickAbility(waveSeriesSoloObject.backBTN);

        //waitForElementClickAbility(primeObj.backHomePagefromRoutine);
        Point backPoint = getCenterCoordinates(primeObj.backHomePagefromRoutine);
        action_clickOnPosition(backPoint.getX(), backPoint.getY());
        System.out.println("Back to Saved tab");
        log.info("Back to Saved tab");
        waitForElementClickAbility(primeObj.homeTab);
        System.out.println("Welcome back to Homepage");
        log.info("Welcome back to Homepage");
    }

    public void quickStart() throws InterruptedException {
        waitForElementClickAbility(deviceObjects.deviceDropDown);
        waitForElementClickAbility(primeObj.quickStart);
        Assert.assertTrue(primeObj.batteryPercentage.isDisplayed());
        System.out.println("Battery percentage is displayed");
        log.info("Battery percentage is displayed");
        waitForElementClickAbility(primeObj.start);
        Thread.sleep(4000);
        waitForElementClickAbility(primeObj.pause);
        System.out.println("Quick start played successfully");
        log.info("Quick start played successfully");
        waitForElementClickAbility(primeObj.backFromQuick);
    }

    public void forgetDevice(){
        waitForElementClickAbility(deviceObjects.deviceDropDown);
        waitForElementClickAbility(waveSeriesSoloObject.settingsIcon);
        Point p = getCenterCoordinates(primeObj.forgetDevice);
        action_clickOnPosition(p.getX(), p.getY());
            waitForElementClickAbility(primeObj.forgetDevicePopupBTN);
            try {
                waitForElementVisibility(primeObj.searchIcon);
                Assert.assertTrue(primeObj.searchIcon.isDisplayed());
            }
            catch (StaleElementReferenceException e){
                System.out.println("Retrying...");
                Assert.assertTrue(primeObj.searchIcon.isDisplayed());
            }
        System.out.println("Device removed successfully");
        log.info("Device removed successfully");
    }

}
