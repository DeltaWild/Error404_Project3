package com.error404.project3.view;

public class Main {
    public static void main(String[] args) {
        // Create and show application's GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SearchGUI.searchGui();
            }
        });
    }
}
