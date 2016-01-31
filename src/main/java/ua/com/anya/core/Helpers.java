package ua.com.anya.core;

public class Helpers {

    public static String generateUniquePhrase(String prefix){
        return prefix + Long.toString(System.currentTimeMillis());
    }
}
