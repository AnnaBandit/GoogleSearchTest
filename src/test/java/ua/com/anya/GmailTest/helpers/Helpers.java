package ua.com.anya.GmailTest.helpers;

public class Helpers {
    public static String generateUniquePhrase(String prefix){
        return prefix + Long.toString(System.currentTimeMillis());
    }
}
