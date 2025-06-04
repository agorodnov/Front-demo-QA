package pageElement;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;

public class DropDownMenu {
    private final String menu;
    private final SelenideElement clickSelector;
    private final SelenideElement choiceSelector;

    public DropDownMenu(String menu, SelenideElement clickSelector, SelenideElement citySelector) {
        this.menu = menu;
        this.clickSelector = clickSelector;
        this.choiceSelector = citySelector;
    }
    public void set(String value){
        System.out.println("Выбор значения из выпадающего списка" + " " + menu);
        clickSelector.click();
        choiceSelector.$(byText(value)).click();
    }
}
