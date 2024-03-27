package testCases;

import base.Setup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFunctions.OnboardingFlowFunctions;
import pageFunctions.PrimeDeviceFunctions;
import pageObjects.PrimeDeviceObjects;

public class PrimeDeviceTCs extends Setup {

    private PrimeDeviceFunctions primeObject;
    private OnboardingFlowFunctions onboardingObject;

    @BeforeClass
    public void init(){
        primeObject = new PrimeDeviceFunctions();
        onboardingObject = new OnboardingFlowFunctions();
    }

    //Demo testcases: 1 & 4
    @Test(priority = 1)
    public void testOpenAndSaveRoutine(){
        primeObject.openAndSaveRoutine();
    }

   /* @Test(priority = 2)
    public void testRemoveSavedRoutineFromRoutineCompletionScreen() throws InterruptedException {
        primeObject.unSaveRoutineFromRoutineCompletionScreen();
    }

    @Test(priority = 3)
    public void testQuickStart() throws InterruptedException {
        primeObject.quickStart();
    }*/

    /*@Test(priority = 2)
    public void testOnboardingCard() throws InterruptedException {
        onboardingObject.onboardingCard();
    }*/

    @Test(priority = 4)
    public void testForgetDevice(){
        primeObject.forgetDevice();
    }
}
