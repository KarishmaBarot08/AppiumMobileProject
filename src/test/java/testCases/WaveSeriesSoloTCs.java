package testCases;

import base.Setup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFunctions.LoginFunctions;
import pageFunctions.WaveSeriesSoloFunctions;

public class WaveSeriesSoloTCs extends Setup {

    public WaveSeriesSoloFunctions wave;
    public LoginFunctions login;
    /*Pre-requisites:
        1. Wave Series Solo device should be already paired.
        2.Solo device should be ON.
        3. Breaks option should be OFF in preferences settings.
        4. Stretching exercises option should be turned ON in preferences settings.*/
    @BeforeClass
    public void init(){
        wave = new WaveSeriesSoloFunctions();
        login = new LoginFunctions();
    }
    //Demo test cases: 1 to 8 & 11
    //Scenario 1.1: Skipping intro screen and performing login
    @Test(priority = 1)
    public void testPairedDeviceHomePage() throws InterruptedException {
        login.skipIntro();
        login.loginFlow();
        wave.verifyPairedDevice();
    }




    //Scenario 1.2: Selecting routine and navigation to its overview screen
    @Test(priority = 2)
    public void testNavigateToRoutineOverview() throws InterruptedException {
        wave.selectRoutine();
    }
    //Scenario 2: Verifying all expected elements are displayed on Routine overview screen
    @Test(priority = 4)
    public void testOverViewScreenElements(){
        wave.routineElements();
    }
    //Scenario 3: Verifying Stretching step is mentioned on Routine overview screen
    @Test(priority = 3)
    public void testStretchingStepElement(){
        wave.stretchingStep();
    }
    //Scenario 4: Start routine, interact with next, previous, pause, close CTAs
    @Test(priority = 5)
    public void testRoutinePlayerBehaviour() throws InterruptedException {
        wave.routinePlayerBehaviour();
    }
    //Scenario 5.1: Start routine, reach to the Stretching step, wait until stretching step finishes, then resume playing
    @Test(priority = 6)
    public void testRoutineStepStretchingBehaviour() throws InterruptedException {
        wave.routineStepStretching();
    }
    //Scenario 6: Toggle off stretching step from preferences, play routine and verify stretching step is not displayed
    @Test(priority = 7)
    public void testSkipStretching() throws InterruptedException {
        wave.removeStretchingStep();

    }
    //Scenario 5.2: Toggle ON break from preferences, play routine and verify break time appears between routine steps
    @Test(priority = 8)
    public void testBreakBetweenSteps() throws InterruptedException {
        wave.addBreak();
    }




    //Scenario 7.1: Save routine from routine overview screen, navigate to Saved tab and verify saved routine is listed
   /* @Test(priority = 9)
    public void testSaveRoutine(){
        wave.saveRoutine();
    }*/

    /*Scenario 7.2: Verify that the routine can be played from saved tab
      Scenario 8.1: Verify that routine can be unsaved from Routine Completion screen*/
    /*@Test(priority = 10)
    public void testPlaySavedRoutineAndUnsaveOnRoutineCompletion() throws InterruptedException {
        wave.playSavedRoutineAndUnsaveOnRoutineCompletion();

    }*/



    //Scenario 10: Navigate to device manager --> edit device screen and verify firmware version is listed
    @Test(priority = 11)
    public void testFirmwareVersion(){
        wave.checkFirmware();
    }
}
