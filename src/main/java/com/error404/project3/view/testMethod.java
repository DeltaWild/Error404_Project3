package com.error404.project3.view;

import java.util.Objects;

public class testMethod {

    public static Object result;

    public static String testMethod(String searchBoxText) {
        String test = searchBoxText;
        if (!Objects.equals(test, "")) {
            searchBoxText = "Success!";
        }
        else {
            searchBoxText = "Please enter a term in the search box.";
        }
        result = searchBoxText;
        return searchBoxText;
    }
}
