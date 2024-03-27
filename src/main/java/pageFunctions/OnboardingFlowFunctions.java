package pageFunctions;

import base.Setup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pageObjects.OnboardingFlowObjects;

public class OnboardingFlowFunctions extends Setup {
    public OnboardingFlowObjects onboarding;
    public static Logger log = LogManager.getLogger(OnboardingFlowFunctions.class);
    public OnboardingFlowFunctions(){
        onboarding = new OnboardingFlowObjects();
    }

    public void onboardingCard() throws InterruptedException {
        Assert.assertTrue(onboarding.getCardHeader("0/4").isDisplayed());
        System.out.println("Onboarding card displayed with header: "+ onboarding.cardHeader.getText());
        log.info("Onboarding card displayed with header: "+ onboarding.cardHeader.getText());
        waitForElementClickAbility(onboarding.startTutorialBTN);
        Thread.sleep(5000);
    }
}
