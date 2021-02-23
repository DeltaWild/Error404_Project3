// Tests if the proper text is printed when the user enters a search term
// Also tests if the text is printed when the user doesn't enter a search term

package com.error404.project3.view;

public class testMethod {

    public static Object result;

    public static String testMethod(String searchBoxText) {
        String test = searchBoxText;
        if (!test.isEmpty()) {
            searchBoxText = "Success!"; // Displays when the passed string value isn't empty
        }
        else {
            searchBoxText = "Please enter a term in the search box."; // Displays when the passed string value is empty //
        }
        result = searchBoxText;
        return searchBoxText;
    }
}
