package tests;

import configuration.AppiumConfiguration;
import models.Auth;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfiguration {

    @Test
    public void loginSuccess(){
        new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillEmail("noa@gmail.com")
                .fillPassword("Nnoa12345$")
                .submitLogin();
    }

    @Test
    public void loginSuccessHomework(){
        Auth auth = Auth.builder()
                .email("noa@gmail.com")
                .password("Nnoa12345$")
                .build();
       new LoginScreen(driver)
               .complexLogin(auth);

    }


}
