package ua.com.anya.GmailTest.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Gmail {

    public static void openGmail(){
        open("http://gmail.com");
    }

    public static void login(String userName, String password) {
        $("#Email").setValue(userName).pressEnter();
        $("#Passwd").setValue(password).pressEnter();
    }
}
