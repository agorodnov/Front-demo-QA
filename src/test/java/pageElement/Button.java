package pageElement;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;


public class Button {
    private final String name;
    private final SelenideElement selector;

    public Button(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }
    public void click() {
        System.out.println("Нажимаем" + " " + name);
        selector.shouldBe(visible).click();
    }
    public void clickClose(){
        System.out.println("Закрываем модалку" + " " + name);
        $(selector)
                .shouldBe(visible, Duration.ofSeconds(30))
                .shouldBe(interactable, Duration.ofSeconds(10))
                .scrollIntoView("{block: 'center'}")
                .click();
    }
    public void clickSubmit (){
        System.out.println("Открываем модалку сабмит" + " " + name);
        $(selector).should(exist).shouldBe(visible);
        $(selector).scrollTo().click();
    }
    public String getCssValue (String Css) {
        System.out.println("Получаем цвет кнопки" + " " + name);
        var color = selector.getCssValue(Css);
        return color;
    }

}
