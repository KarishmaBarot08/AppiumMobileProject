package pageFunctions;

import base.Setup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Point;
import org.testng.Assert;
import pageObjects.AddDeviceObjects;
import pageObjects.WaveSeriesSoloObjects;

import java.util.HashMap;
import java.util.Map;

public class AddDeviceFunctions extends Setup {

    private AddDeviceObjects obj;
    private WaveSeriesSoloObjects waveSeriesSoloObject;

    public static Logger log = LogManager.getLogger(AddDeviceFunctions.class);

    public AddDeviceFunctions() {
        obj = new AddDeviceObjects();
        waveSeriesSoloObject = new WaveSeriesSoloObjects();
    }

    /*Pre-requisites:
    1. This method pairs Theragun Prime device. Remove 'prime' device from paired list before calling this function.
    2. Turn on Prime device.
    3. Turn on device's bluetooth'*/

    public void selectDevice(String deviceName) throws InterruptedException {
        waitForElementClickAbility(obj.deviceDropDown);
        Thread.sleep(5000);
        waitForElementClickAbility(obj.addNewDevice);
        //selecting Theragun Prime device
        waitForElementClickAbility(obj.theragun);
        obj.getTheragunDevice(deviceName);
        waitForElementClickAbility(obj.theragunDevice);
    }
    /*public void selectDevice() throws InterruptedException {
        //selecting Theragun Pro Plus device
        obj.theragun.click();
        obj.proPlus.click();
    }*/

    public void pairDeviceBLon(){
        if(platform_param.equalsIgnoreCase("iOS")) {
            waitForElementClickAbility(obj.enableBluetooth);
            //driver.switchTo().alert().accept();
        }
        waitForElementClickAbility(obj.pairDevice);
        waitForElementClickAbility(obj.pairPrime);
        waitForElementClickAbility(obj.skipDeviceOnboarding);
        if (platform_param.equalsIgnoreCase("Android")) {
            Point centerPoint = getCenterCoordinates(waveSeriesSoloObject.closeDeviceManager);
            action_clickOnPosition(centerPoint.getX(), centerPoint.getY());
        } else {
            waitForElementClickAbility(waveSeriesSoloObject.closeDeviceManager);
        }
        System.out.println("Welcome back to HomeScreen!");
        log.info("Welcome back to HomeScreen!");

        /*if (platform_param.equalsIgnoreCase("iOS")) {
            waitForElementClickAbility(obj.enableNotification);
            driver.switchTo().alert().accept();
        }
        waitForElementClickAbility(obj.deviceDropDown);
        waitForElementVisibility(obj.pairedDevicePrime);
        String pairedDevice = obj.pairedDevicePrime.getText();
        System.out.println("Fetched device name is: " + pairedDevice);
        log.info("Fetched device name is: " + pairedDevice);
        Assert.assertTrue(pairedDevice.contains("Theragun Prime"));*/
    }

    /*Pre-requisites:
    1. Turn off mobile phone bluetooth
    2. No device should be already paired*/
    public void pairDeviceBLoff() throws InterruptedException {
        waitForElementClickAbility(obj.enableBluetooth);
        acceptAlert();

        //openBluetoothSettings();
        if (platform_param.equalsIgnoreCase("Android")) {
            waitForElementClickAbility(obj.bluetoothBtn);
        }
        System.out.println("Alert appeared: " + driver.switchTo().alert().getText());
        log.info("Alert appeared: " + driver.switchTo().alert().getText());
        if (platform_param.equalsIgnoreCase("iOS")) {


            driver.switchTo().alert().accept();

            Map<String, Object> args = new HashMap<>();
            args.put("bundleId", "com.apple.Preferences");
            driver.executeScript("mobile: launchApp", args);

            if (obj.bluetoothTab.isDisplayed()) {
                obj.bluetoothTab.click();
            }


            //driver.findElement(By.id("Bluetooth")).click();
            //action_clickOnPosition(334,149);
            obj.bluetoothBtn.click();
            Thread.sleep(5000);

            System.out.println("Toggle turned ON");
            log.info("Toggle turned ON");
            Map<String, Object> args2 = new HashMap<>();
            args2.put("bundleId", "com.theragun.consumer.stage");
            driver.executeScript("mobile: launchApp", args2);
            Thread.sleep(1000);
            driver.switchTo().alert().accept();
        }


        waitForElementClickAbility(obj.pairDevice);
        obj.pairProPlus.click();

        waitForElementClickAbility(obj.skipDeviceOnboarding);


        if (platform_param.equalsIgnoreCase("iOS")) {
            Thread.sleep(8000);
            obj.enableNotification.click();
            driver.switchTo().alert().accept();
        }

        waitForElementClickAbility(obj.deviceDropDown);


        waitForElementVisibility(obj.getPairedDeviceProPlus);
        String pairedDevice = obj.getPairedDeviceProPlus.getText();
        System.out.println("Fetched device name is: " + pairedDevice);
        log.info("Fetched device name is: " + pairedDevice);
        Assert.assertTrue(pairedDevice.contains("Theragun PRO Plus"));
    }


    public static void openBluetoothSettings() {
        try {
            // Specify the adb command to open Bluetooth settings
            String adbCommand = "adb shell am start -a android.settings.BLUETOOTH_SETTINGS";

            // Execute the adb command
            Process process = Runtime.getRuntime().exec(adbCommand);

            // Wait for the process to complete
            process.waitFor();

            // Get the exit value of the process
            int exitValue = process.exitValue();

            if (exitValue == 0) {
                System.out.println("Bluetooth settings page opened successfully.");
                log.info("Bluetooth settings page opened successfully.");
            } else {
                System.err.println("Failed to open Bluetooth settings page.");
                log.info("Failed to open Bluetooth settings page.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
