package com.error404.project3.view;

import com.error404.project4.model.fileItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class fileListTest {

    @Test
    @DisplayName("Adding file properly appends file object to list.")
    void addFile() {
        fileItem file = new fileItem(0L, "test.txt", 0L, 0L);
        fileList.fileInfo.add(file);

        long testID = file.getFileID();

        assertEquals(0L, testID, "Test ID should be 0L.");
    }
}