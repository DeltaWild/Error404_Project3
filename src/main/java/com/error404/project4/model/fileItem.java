package com.error404.project4.model;

public class fileItem {
    public final String fileName;
    public final long fileSize;
    public long fileModDate;

    public fileItem(String fileName, long fileSize, long fileModDate) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileModDate = fileModDate;
    }
}
