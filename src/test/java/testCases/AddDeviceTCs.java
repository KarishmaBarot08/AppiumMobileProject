package testCases;

import base.Setup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFunctions.AddDeviceFunctions;

public class AddDeviceTCs extends Setup {
    private AddDeviceFunctions fun;
    @BeforeClass
    public void init(){
        fun = new AddDeviceFunctions();
    }

    @Test
    public void testPairDeviceBLon() throws InterruptedException {
        fun.selectDevice("Prime");
        fun.pairDeviceBLon();
    }

   /* @Test
    public void testPairDeviceBLoff() throws InterruptedException {
        fun.selectDevice();
        fun.pairDeviceBLoff();
    }*/
}
