package tests;

import configuration.AppiumConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class LaunchTest extends AppiumConfiguration {

    @Test
    public void launchTest(){
        String version = new SplashScreen(driver).getCurrencyVersion();//открываем первый приветственный экран и вычитываем текст который мы искали
        Assert.assertEquals(version, "0.0.3");
    }
}
