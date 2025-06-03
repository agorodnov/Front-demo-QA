package Settings;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class Configuration {
    private static void setlocalDriver (){
        com.codeborne.selenide.Configuration.browser = "Chrome";
        com.codeborne.selenide.Configuration.browserSize = "1920х1080";
        com.codeborne.selenide.Configuration.pageLoadTimeout = 600000;
    }

    @BeforeEach
    void setDriver(){
        setlocalDriver();
        Selenide.open("https://demoqa.com/automation-practice-form");
    }
    @AfterEach
    void tearDown(){
        Selenide.closeWebDriver();
    }
}
