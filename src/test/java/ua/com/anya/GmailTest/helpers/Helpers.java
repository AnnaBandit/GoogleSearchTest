package ua.com.anya.GmailTest.helpers;

public class Helpers {
    public static String generateUniqueSubjectWithSetText(String text){
        return text + Long.toString(System.currentTimeMillis());
    }
}
