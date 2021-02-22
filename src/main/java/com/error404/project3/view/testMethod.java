package com.error404.project3.view;

public class testMethod {

    public static Object result;

    public static String testMethod(String searchBoxText) {
        String test = searchBoxText;
        if (!test.isEmpty()) {
            searchBoxText = "Success!";
        }
        else {
            searchBoxText = "Please enter a term in the search box.";
        }
        result = searchBoxText;
        return searchBoxText;
    }
}
