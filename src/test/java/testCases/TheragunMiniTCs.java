package testCases;

import base.Setup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFunctions.AddDeviceFunctions;
import pageFunctions.PrimeDeviceFunctions;
import pageFunctions.TheragunMiniFunctions;

public class TheragunMiniTCs extends Setup {
    public TheragunMiniFunctions miniFunctions;
    public PrimeDeviceFunctions primeDeviceFunctions;

    @BeforeClass
    public void init(){
        miniFunctions = new TheragunMiniFunctions();
        primeDeviceFunctions = new PrimeDeviceFunctions();
    }

    @Test(priority = 1)
    public void testSelectDevice(){
        miniFunctions.pairMiniGeneration1();
    }

    /*@Test(priority = 2)
    public void testVerifyPairedDevice(){
        miniFunctions.verifyPairedDevice();
    }


    @Test(priority = 4)
    public void testSaveRoutine(){
        primeDeviceFunctions.openAndSaveRoutine();
    }*/

    @Test(priority = 5)
    public void testForgetDevice(){
        primeDeviceFunctions.forgetDevice();
    }
}
