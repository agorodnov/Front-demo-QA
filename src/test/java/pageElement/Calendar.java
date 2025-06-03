package pageElement;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Calendar {
    private final String name;
    private final SelenideElement selectorCaledar;
    private final SelenideElement selectorDay;
    private final SelenideElement selectorMonth;
    private final SelenideElement selectorYear;

    public Calendar(String calendar, SelenideElement selectorCaledar,
                    SelenideElement selectorDay, SelenideElement selectorMonth, SelenideElement selectorYear) {

        this.name = calendar;
        this.selectorDay = selectorDay;
        this.selectorMonth = selectorMonth;
        this.selectorYear = selectorYear;
        this.selectorCaledar = selectorCaledar;
    }
    public void setCalendar(String month, String year, String day){
        System.out.println("Заполняем календарь" + " " + name);
        selectorCaledar.click();
        $x("//label[text()='Date of Birth']/following::input").click();
        // Выбор года
        $(".react-datepicker__year-select").selectOption(year);
        // Выбор месяца
        $(".react-datepicker__month-select").selectOption(month);
        // Клик на день
        $x("//div[contains(@class,'react-datepicker__day react-datepicker__day--013')]").click();
    }
//        waitForElementMonth(selectorMonth);
//        SelenideElement monthElement = $x("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select/option[5]");
//        monthElement.click();
////        selectorMonth.click();
////        selectorMonth.selectOption(month);
//
//        waitForElement(selectorYear);
//        selectorYear.click();
//        selectorYear.selectOption(years);
//
//        SelenideElement dayElement = $x("//div[@class='react-datepicker__day react-datepicker__day--013']");
//        dayElement.click();
//    }
//    private void waitForElement(SelenideElement element){
//        element.shouldBe(Condition.visible);
//    }
//    private void waitForElementMonth(SelenideElement element){
//        element.shouldBe(Condition.visible);
//        element.should(exist,Duration.ofSeconds(timeout));
}
//selectorDay.selectOption(day);
//        selectorMonth.selectOption(month);
//        selectorYear.selectOption(years);