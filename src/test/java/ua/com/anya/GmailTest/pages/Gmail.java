package ua.com.anya.GmailTest.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class Gmail {

    public static void open(){
        Selenide.open("http://gmail.com");
    }

    public static void login(String userName, String password) {
        $("#Email").setValue(userName).pressEnter();
        $("#Passwd").setValue(password).pressEnter();
    }
}
