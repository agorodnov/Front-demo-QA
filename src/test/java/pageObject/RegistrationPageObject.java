package pageObject;


import org.openqa.selenium.By;
import pageElement.*;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPageObject {

    private final String TITLE_TEXT = "Student Registration Form";
    private final Url url = new Url("https://demoqa.com/automation-practice-form", "Practice Form");
    private final Input firstName = new Input("Имя",$("#firstName"));
    private final Input lastName = new Input("Фамилия",$("#lastName"));
    private final Input email = new Input ("Email", $("#userEmail"));
    private static final Button genderButton = new Button("Выбор пола", $(".custom-control-label"));
    private final Input telephoneNumber = new Input ("Номер телелефона", $("#userNumber"));
    private final Calendar calendar = new Calendar("Календарь",$(By.xpath("//label[text()='Date of Birth']/following::input")) , $(".react-datepicker__year-select"),$(".react-datepicker__month-select"), $x("//div[contains(@class,'react-datepicker__day react-datepicker__day--013')]"));
    private final Input subject = new Input ("Предметы", $("#subjectsInput"));
    private final Button hobbies = new Button ("Хобби", $("#hobbiesWrapper"));
    private final UploadFile picture = new UploadFile("Изображение", $("#uploadPicture"));
    private final Input currentAddress = new Input("Адрес",$("#currentAddress"));
    private final DropDownMenu state = new DropDownMenu("Штат", $("#state"), $("#stateCity-wrapper"));
    private final DropDownMenu city = new DropDownMenu("Город", $("#city"), $("#stateCity-wrapper"));
    private final Button submit = new Button("Submit", $("#submit"));
    private final Button submitScroll = new Button("Submit", $("#submit"));
    private final Button closeButton = new Button("Close", $("button#closeLargeModal"));

    @Step("Проверка лого")
    public RegistrationPageObject openPage(){
        url.openUrl();
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        return this;
    }

    @Step("Ввод Фамилии")
    public RegistrationPageObject setFirstName(String value){
        firstName.setValue(value);
        return this;
    }

    @Step("Ввод Имя")
    public RegistrationPageObject setLastName(String value){
        lastName.setValue(value);
        return this;
    }

    @Step("Ввод email")
    public RegistrationPageObject setEmail(String value) {
        email.setValue(value);
        return this;
    }

    @Step("Клик на пол")
    public RegistrationPageObject setGender() {
        genderButton.click();
        return this;
    }

    @Step("Ввод телефона")
    public RegistrationPageObject setTelephoneNumber(String value) {
        telephoneNumber.setValue(value);
        return this;
    }

    @Step("Ввод календарь")
    public RegistrationPageObject setCalendar(String month, String year, String day) {
        calendar.setCalendar(month, year, day);
        return this;
    }

    @Step("Ввод Предметы")
    public RegistrationPageObject setSubjects(String value) {
        subject.setSubject(value);
        return this;
    }

    @Step("Ввод Хобби")
    public RegistrationPageObject setHobbies() {
        hobbies.click();
        return this;
    }

    @Step("Загрузить картинку")
    public RegistrationPageObject setPicture(String value) {
        picture.uploadFile(value);
        return this;
    }

    @Step("Ввод адрес")
    public RegistrationPageObject setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    @Step("Ввод штат")
    public RegistrationPageObject setState(String value) {
        state.set(value);
        return this;
    }

    @Step("Ввод город")
    public RegistrationPageObject setCity(String value) {
        city.set(value);
        return this;
    }

    @Step("Клик на кнопку подтвердить ввод")
    public void submit() {
        submit.click();
    }

    @Step("Клик на кнопку закрыть окно авторизации")
    public RegistrationPageObject closeButton() {
        $("button#closeLargeModal").should(visible, Duration.ofSeconds(10));
        closeButton.clickClose();
        return this;
    }

    @Step("Получить цвет к полю Фамилия")
    public String InputGetCssValueLastName(){
        String color = lastName.getCssValue("border-color");
        return color;
    }

    @Step("Клик на кнопку submit с ожиданием + скрол")
    public RegistrationPageObject submitScroll(){
        submitScroll.clickSubmit();
        return this;
    }

    @Step("Получить цвет к полю Фамилия")
    public String InputGetCssValueFirstname() {
        String color = firstName.getCssValue("border-color");
        return color;
    }

    @Step("Получить цвет к полю Номер телефона")
    public String InputGetCssValueTelephoneNumber() {
        String color = telephoneNumber.getCssValue("border-color");
        return color;
    }

    @Step("Получить цвет к кнопке пол")
    public static String ButtonGetCssValueGender(){
        String color = genderButton.getCssValue("color");
        return color;
    }

    @Step("Получить цвет к полю Еmail")
    public String InputGetCssValueEmail(){
        String color = email.getCssValue("border-color");
        return color;
    }
}
