package pageElement;

import com.codeborne.selenide.Selenide;


public class Url {
    private final String URL;
    private final String name;


    public Url(String URL, String name) {
        this.name = name;
        this.URL = URL;
    }
    public void openUrl(){
        System.out.println("Открываем" + " " + name);
        Selenide.open(URL);
    }
}
