package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utilities.UtilityMethods;


import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class Setup {
    public static AppiumDriverLocalService service;
    public static AppiumDriver driver;
    public static String platform_param, email_param;
    public static UtilityMethods utilityMethods;
    public static Logger log = LogManager.getLogger(Setup.class);


    @BeforeTest
    @Parameters({"platform", "email"})
    public void startAppiumServer(String platform, String email) throws InterruptedException {
        checkIfServerIsRunnning(4732);

        int maxRetryCount = 3;
        int retryCount = 0;

        do {
            try {
                //service = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js")).withIPAddress("127.0.0.1").usingPort(4723).withArgument(() -> "--use-plugins", "execute-driver").build();
                service = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js")).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(30)).build();

                service.start();
                launchApp(platform);
                platform_param = platform;
                email_param = email;
                break;

            } catch (Exception e) {
                System.out.println("An exception occurred while starting Appium server: " + e.getMessage());

                // Retry logic
                retryCount++;
                if (retryCount <= maxRetryCount) {
                    System.out.println("Retrying Appium server start (Retry " + retryCount + ")");
                    System.out.println("System will wait for 15 seconds. Please take needful action.");
                    Thread.sleep(15000);
                } else {
                    System.out.println("Maximum retry count reached. Unable to start Appium server.");

                    throw new RuntimeException("Failed to start Appium server after maximum retries");
                }
            }
        } while (retryCount <= maxRetryCount);
        utilityMethods = new UtilityMethods();
    }

    public static void launchApp(String platformName){
        DesiredCapabilities dc = new DesiredCapabilities();
        if(platformName.equalsIgnoreCase("iOS")){
            dc.setCapability("automationName", "XCUITest");
            dc.setCapability("platformName", "iOS");
            dc.setCapability("platformVersion", "16.1.1");
            dc.setCapability("deviceName", "iPhone (2)");
            dc.setCapability("udid", "00008030-000258281E3B802E");
            dc.setCapability("appium:plugins", "execute-driver");
            //dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            dc.setCapability("app", "/Users/karishmabarot/Documents/Projects/TheraBody/Builds/qa_automation/therabody-stage.ipa");
            dc.setCapability("autoGrantPermissions",true);
            dc.setCapability("noReset",false);
            //driver = new AppiumDriver(service.getUrl(), dc);
            driver = new IOSDriver(service.getUrl(),dc);
        }
        else if(platformName.equalsIgnoreCase("Android")){
            dc.setCapability("platformName", "Android");
            dc.setCapability("platformVersion", "11");
            dc.setCapability("deviceName", "Moto G31");
            dc.setCapability("automationName", "UiAutomator2");
            dc.setCapability("appPackage", "com.g4app.stage");
            dc.setCapability("appActivity", "com.g4app.ui.MainActivity");
            dc.setCapability("fullReset",true);
            dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            dc.setCapability("app", "/Users/karishmabarot/Documents/Projects/TheraBody/Builds/app-rc-release.apk");
            dc.setCapability("autoGrantPermissions",true);

            //driver = new AppiumDriver(service.getUrl(), dc);
            driver = new AndroidDriver(service.getUrl(),dc);

        }
    }

    public static boolean checkIfServerIsRunnning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            isServerRunning = true;
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    // Handle exception if needed
                }
            }
        }

        return isServerRunning;
    }
    public static void waitForElementClickAbility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void waitForElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void action_clickOnPosition(int pointA_X, int pointA_Y) {
        PointerInput finger = new PointerInput(org.openqa.selenium.interactions.PointerInput.Kind.TOUCH, "finger");
        org.openqa.selenium.interactions.Sequence clickPosition = new org.openqa.selenium.interactions.Sequence(finger, 1);
        clickPosition.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), pointA_X, pointA_Y)).addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())).addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(clickPosition));
    }

    public static void acceptAlert(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        if(alert != null) {

            driver.switchTo().alert().accept();
        }
    }

    public static Point getCenterCoordinates(WebElement element) {
        int elementX = element.getLocation().getX();
        int elementY = element.getLocation().getY();

        int elementWidth = element.getSize().getWidth();
        int elementHeight = element.getSize().getHeight();

        int centerX = elementX + (elementWidth / 2);
        int centerY = elementY + (elementHeight / 2);

        return new Point(centerX, centerY);
    }

    public void clickElementWithRetry(WebElement element) {
        if (element == null) {
            System.out.println("Element is null. Cannot perform click.");
            log.info("Element is null. Cannot perform click.");
            return;
        }

        int attempts = 0;
        while (attempts < 2) {
            try {
                System.out.println("Trying to click");
                log.info("Trying to click");
                waitForElementVisibility(element);
                element.click();
                break;
            } catch (StaleElementReferenceException e) {
                PageFactory.initElements(new AppiumFieldDecorator(driver), this);
                System.out.println("StaleElementReferenceException or StaleObjectException occurred. Retrying...");
                log.info("StaleElementReferenceException or StaleObjectException occurred. Retrying...");
            }
            attempts++;
        }
    }
    @AfterTest
    public void tearDown() {

        if (service != null && service.isRunning()) {
            // Check if the server is responsive before stopping
            if (isAppiumServerResponsive(service.getUrl(), 5000)){
            service.stop();
            }
        }
        if (driver != null) {
            driver.quit();
        }
        // Add a short wait to ensure the server has fully stopped
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private boolean isAppiumServerResponsive(URL serverUrl, int timeoutMillis) {
        try {
            HttpURLConnection connection = (HttpURLConnection) serverUrl.openConnection();
            connection.setConnectTimeout(timeoutMillis);
            connection.connect();
            int responseCode = connection.getResponseCode();
            return (responseCode == HttpURLConnection.HTTP_OK);
        } catch (IOException e) {
            return false;
        }
    }

    public static void scrollIntoView(WebElement element) {
        // Use MobileBy to create a locator for the scrolling container
        By scrollingContainer = MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeScrollView'");

        // Use MobileBy to create a locator for the element to scroll to
        By elementLocator = MobileBy.AccessibilityId(String.valueOf(element));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Perform scrolling and wait for the element to be present
        wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(scrollingContainer));

        // Perform the actual scroll
        driver.findElement(scrollingContainer);
    }
}
