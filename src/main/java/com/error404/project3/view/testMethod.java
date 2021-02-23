// Tests if the proper text is printed when the user enters a search term
// Also tests if the text is printed when the user doesn't enter a search term

package com.error404.project3.view;

public class testMethod {

    public static Object result;

    public static String testMethod(String searchBoxText) {
        String test = searchBoxText;
        if (!test.isEmpty()) {
            searchBoxText = "Success!"; // Prints to the terminal window when the user enters a search term
        }
        else {
            searchBoxText = "Please enter a term in the search box."; // Prints to the terminal window when the user doesn't enter a search term
        }
        result = searchBoxText;
        return searchBoxText;
    }
}
