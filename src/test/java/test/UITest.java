package test;
import Data.InvalidData;
import Data.ValidData;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Settings.Configuration;
import pageObject.CheckPageResult;
import pageObject.RegistrationPageObject;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Проверка формы регистрации студента")
public class UITest extends Configuration {
    RegistrationPageObject registrationPageObject = new RegistrationPageObject();
    ValidData validData = new ValidData();
    InvalidData invalidData = new InvalidData();

    @Test
    @DisplayName("Проверка заполнения формы валидными данными")
    public void ValidDataSubmission() {
        registrationPageObject.openPage()
                .setFirstName(validData.getFirstName())
                .setLastName(validData.getLastName())
                .setEmail(validData.getEmail())
                .setGender()
                .setTelephoneNumber(validData.getTelephoneNumber())
                .setCalendar(validData.getMonth(),validData.getYear(),validData.getDay())
                .setSubjects(validData.getSubjects())
                .setHobbies()
                .setPicture(validData.getFile())
                .setCurrentAddress(validData.getAddress())
                .setState(validData.getState())
                .setCity(validData.getCity())
                .submit();
        Selenide.sleep(120);

        CheckPageResult.checkVisible()
                .verifyFieldValue("Student Name", validData.getFirstName() + " " + validData.getLastName()
                        , "Имя и Фамилию")
                .verifyFieldValue("Student Email", validData.getEmail(), "Почта")
                .verifyFieldValue("Gender", validData.getGender(), "Пол")
                .verifyFieldValue("Mobile", validData.getTelephoneNumber(), "номер телефона")
                .verifyFieldValue("Date of Birth", validData.getDay() + " " + validData.getMonth() + ","
                        + validData.getYear(), "Дата рождения")
                .verifyFieldValue("Subjects", validData.getSubjects(), "Предмет")
                .verifyFieldValue("Hobbies", validData.getHobbies(), "Хобби")
                .verifyFieldValue("Picture", validData.getFile(), "Загруженный файл")
                .verifyFieldValue("Address", validData.getAddress(), "адрес")
                .verifyFieldValue("State and City", validData.getState() + " " + validData.getCity(),
                        "штат и город");
        registrationPageObject.closeButton();
    }

    @Test
    @DisplayName("Проверка валидации полей, пустые поля")
    public void registrationPageObjectNegativeTest(){
        registrationPageObject.openPage()
                .submitScroll();
        Selenide.sleep(100);
        assertThat(invalidData.getInputRedColor()).as("Ввод имени - цвет не совпадает")
                .isEqualTo(registrationPageObject.InputGetCssValueFirstname());
        assertThat(invalidData.getInputRedColor()).as("Ввод Фамилии - цвет не совпадает")
                .isEqualTo(registrationPageObject.InputGetCssValueLastName());
        assertThat(invalidData.getInputRedColor()).as("Ввод телефона и цвет не совпадает")
                .isEqualTo(registrationPageObject.InputGetCssValueTelephoneNumber());
        assertThat(RegistrationPageObject.ButtonGetCssValueGender()).as("клик на пол цвет не совпадает")
                .isEqualTo(invalidData.getButtonRedColor());
    }

    @Test
    @DisplayName("Валидация полей Вводим в поле телефон буквы")
    public void InputTelephoneNumberNegativeTest() {
        registrationPageObject.openPage()
                .setTelephoneNumber(invalidData.getTelephone())
                .submitScroll();
        Selenide.sleep(500);
        assertThat(invalidData.getInputRedColor()).as("Ввод телефона - цвет не совпадает")
                .isEqualTo(registrationPageObject.InputGetCssValueTelephoneNumber());

    }

    @Test
    @DisplayName("Валидация полей.Вводим в поле Email цифры")
    public void InputEmailNegativeTest() {
        registrationPageObject.openPage()
                .setEmail(invalidData.getEmail())
                .submitScroll();
        Selenide.sleep(500);
        assertThat(invalidData.getInputRedColor()).as("Ввод Email - цвет не совпадает")
                .isEqualTo(registrationPageObject.InputGetCssValueEmail());
    }
}