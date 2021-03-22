package com.error404.project3.view;

public class ListItem implements Comparable<ListItem> {
    /* ***** */
    public String fileName = "";
    public long lastModified;
    public boolean isUTD;

    public ListItem(String fileName, long lastModified, boolean isUTD) {
        this.fileName = fileName;
        this.lastModified = lastModified;
        this.isUTD = isUTD;
    }
    /* ***** */

    @Override
    public int compareTo(ListItem o) {
        return 0;
    }
}
