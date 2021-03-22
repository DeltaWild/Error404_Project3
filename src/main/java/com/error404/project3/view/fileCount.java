/*
Method for the indexed file counter.
*/

package com.error404.project3.view;

class fileCount extends fileList {

    public void fileCount() {
        int fileCount = getFileCount();
        MaintenanceGUI.maintIndexCount.setText(String.valueOf(fileCount));
        SearchGUI.indexCount.setText(String.valueOf(fileCount));
    }

}
