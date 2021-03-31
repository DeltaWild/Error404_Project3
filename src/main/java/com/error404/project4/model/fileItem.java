package com.error404.project4.model;

import java.util.Objects;

public class fileItem implements Comparable<fileItem>{
    public final long fileID;
    public final String fileName;
    public final long fileSize;
    public long fileModDate;

    public fileItem(long fileID, String fileName, long fileSize, long fileModDate) {
        this.fileID = fileID;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileModDate = fileModDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        else {
            fileItem file2 = (fileItem) o;
            if (this.fileID != file2.fileID) {
                return false;
            }
            else {
                if (this.fileName == null) {
                    return false;
                }
                return true;
            }
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fileID, this.fileName, this.fileSize, this.fileModDate);
    }

    @Override
    public String toString() {
        return "fileItem{" + "fileName='" + this.fileName + '\'' + '}';
    }

    @Override // Need to provide comparison for equals, etc. operations
    public int compareTo(fileItem file2) {
        return (int)(this.fileID - file2.fileID);
    }
}
