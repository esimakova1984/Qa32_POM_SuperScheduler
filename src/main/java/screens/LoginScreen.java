package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Auth;
import org.openqa.selenium.support.FindBy;

public class LoginScreen extends BaseScreen{

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement emailEditText;

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditElement;

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;

    public LoginScreen fillEmail(String email){//так как мы остаемся на этой же странице то пишем "public LoginScreen fillEmail(String email)"
        //pause(6000);
        should(emailEditText, 15);//WebDriverWait
        type(emailEditText, email);
        return this;//return new LoginScreen(driver);//так как мы остаемся на этой же странице то возвращаем ее же
    }

    public LoginScreen fillPassword(String password){
        type(passwordEditElement, password);
        return this;
    }

    public HomeScreen submitLogin(){//переходим на страницу HomeScreen
        driver.hideKeyboard();//скрывает клавиатуру
        loginButton.click();
        return new HomeScreen(driver);//так как мы переходим на другую страницу то возвращваем новую страницу

    }

    public HomeScreen complexLogin(Auth auth){
        should(emailEditText, 15);
        type(emailEditText, auth.getEmail());
        type(passwordEditElement, auth.getPassword());
        driver.hideKeyboard();
        loginButton.click();
        return new HomeScreen(driver);
    }
}
