// Tests whether the user has entered a value in the search field,
// returns a message to the results field based on comparison,
// and displays "Success!" if the search field has been populated and a request for input if the search field is empty

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
