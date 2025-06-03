package pageElement;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.cssValue;


public class Input {
    private final String name;
    private final SelenideElement selector;

    public Input(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }
    @Step("Вводим значение в поле ввода")
    public void setValue (String value){
        System.out.println("Ввод данных" + " " + name);
        selector.setValue(value);
    }
    @Step("Ввод значения в поле предметы")
    public void setSubject(String value) {
        System.out.println("Заполняем Предметы" + " " + name);
        selector.sendKeys(value);
        selector.sendKeys(Keys.TAB);
    }
    public String getCssValue(String Css) {
        System.out.println("Получаем цвет поля" + " " + name);
        var color = selector.getCssValue(Css);
        return color;
    }
//    public String getCssValue(String Css, String expectedValue) {
//        // ...
//        selector.shouldHave(cssValue(Css, expectedValue));
//        return selector.getCssValue(Css);
//    }
}
