package pageObject;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckPageResult {
    private final static String TITLE_TEXT = "Thanks for submitting the form";

    public static CheckPageResult checkVisible() {
        System.out.println("Итоговая таблица загрузилась");
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT));
        return new CheckPageResult();
    }

    public CheckPageResult verifyFieldValue(String label, String value, String name) {
        System.out.println("Проверка поля: " + name);
        $(".table-responsive table")
                .$(byText(label))
                .parent()
                .shouldHave(text(value));
        return this;
    }
}
