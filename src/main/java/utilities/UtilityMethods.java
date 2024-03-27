package utilities;

import base.Setup;
import org.openqa.selenium.WebElement;
import pageObjects.WaveSeriesSoloObjects;

public class UtilityMethods extends Setup {


    public UtilityMethods(){

    }
    // Method to get the toggle switch status (ON/OFF)
    public String getToggleSwitchStatus(WebElement element) {
        if(platform_param.equalsIgnoreCase("iOS")) {
            String switchStatus = element.getAttribute("value");
            if (switchStatus != null && switchStatus.equals("1")) {
                return "ON";
            } else {
                return "OFF";
            }
        }
        else{
            String switchStatus = element.getAttribute("checked");
            if (switchStatus != null && switchStatus.equals("true")) {
                return "ON";
            } else {
                return "OFF";
            }
        }
    }

    //Method to toggle switch OFF
    public void toggleSwitchIfOff(WebElement element) {
        String currentStatus = getToggleSwitchStatus(element);

        if (currentStatus.equals("ON")) {
            clickElementWithRetry(element);
            System.out.println("Toggled the switch to OFF");
        } else {
            System.out.println("Switch is already OFF. No action needed.");
        }
    }

    //Method to toggle switch ON
    public void toggleSwitchIfOn(WebElement element) {
        String currentStatus = getToggleSwitchStatus(element);

        if (!(currentStatus.equals("ON"))) {
            clickElementWithRetry(element);
            System.out.println("Toggled the switch to ON");
        } else {
            System.out.println("Switch is already ON. No action needed.");
        }
    }
}
