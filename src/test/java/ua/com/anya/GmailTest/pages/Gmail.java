package ua.com.anya.GmailTest.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Gmail {

    public Gmail(){
        open("http://gmail.com");
    }
    public void loginToGmail(String userName, String password) {
        $("#Email").setValue(userName).pressEnter();
        $("#Passwd").setValue(password).pressEnter();
    }
}
