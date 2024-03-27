package testCases;

import base.Setup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFunctions.LoginFunctions;

public class LoginTCs extends Setup {

    private LoginFunctions func;

    @BeforeClass
    public void init(){
        func = new LoginFunctions();
    }

    @Test(priority = 1)
    public void testIntroScreen() throws InterruptedException {
        func.skipIntro();
    }

    @Test(priority = 2)
    public void testLogin() throws InterruptedException {
        func.loginFlow();
    }
}
