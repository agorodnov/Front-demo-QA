package pageElement;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

public class UploadFile {
    private final String name;
    private final SelenideElement selector;

    public UploadFile(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    public void uploadFile(String file) {
        File imageFile = new File("C:\\Users\\a.gorodnov\\IdeaProjects\\Front-demo-QA\\src\\test\\resources\\1.png");
        System.out.println("Грузим файл" + " " + name);
        selector.uploadFromClasspath(String.valueOf(file));
    }
}
