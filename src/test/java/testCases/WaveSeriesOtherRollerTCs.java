package testCases;

import base.Setup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFunctions.PrimeDeviceFunctions;
import pageFunctions.WaveSeriesOtherRollerFunctions;
import pageFunctions.WaveSeriesSoloFunctions;

public class WaveSeriesOtherRollerTCs extends Setup {

    public WaveSeriesOtherRollerFunctions waveRollerFunctions;
    public WaveSeriesSoloFunctions waveSoloFunctions;
    public PrimeDeviceFunctions primeDeviceFunctions;

    @BeforeClass
    public void init(){
        waveRollerFunctions = new WaveSeriesOtherRollerFunctions();
        waveSoloFunctions = new WaveSeriesSoloFunctions();
        primeDeviceFunctions = new PrimeDeviceFunctions();
    }

    @Test(priority = 1)
    public void testPairOtherRollerDevice(){
        waveRollerFunctions.pairOtherRoller();
    }

    @Test(priority = 2)
    public void testSelectRoutine() throws InterruptedException {
        waveRollerFunctions.selectRoutine();
    }

   /* @Test(priority = 3)
    public void testStretchingStep() throws InterruptedException {
        waveSoloFunctions.routineStepStretching();
    }*/

   /* @Test(priority = 4)
    public void testBreakToggle() throws InterruptedException {
        waveSoloFunctions.addBreak();
    }*/

    @Test(priority = 5)
    public void testNotConnectedMode(){
        waveRollerFunctions.notConnectedMode();
    }

    @Test(priority = 6)
    public void testPreferencesOnProfile(){
        waveRollerFunctions.preferencesOnProfile();
    }

    @Test(priority = 7)
    public void testTipForNonBLE() throws InterruptedException {
        waveRollerFunctions.tipForNonBLE();
    }

    @Test(priority = 8)
    public void testRoutineCompletionForNonBLE() throws InterruptedException {
        waveRollerFunctions.routineCompletionForNonBLE();
    }

    @Test(priority = 9)
    public void testSaveRoutineFromCompletionScreen(){
        waveRollerFunctions.saveRoutineFromCompletionScreen();
    }

    @Test(priority = 10)
    public void testUnSaveRoutineFromRoutineCompletionScreen() throws InterruptedException {
        waveRollerFunctions.unSaveRoutineFromRoutineCompletionScreen();
    }
    @Test(priority = 11)
    public void testForgetDevice(){
       // waveRollerFunctions.backHomePage();
        primeDeviceFunctions.forgetDevice();
    }
}
