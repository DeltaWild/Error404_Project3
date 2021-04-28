package com.error404.project4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class fileItemTest {

    @Test
    @DisplayName("Get file ID returns long type ID")
    void getFileID() {
        fileItem file = new fileItem(0L, "test.txt", 0L, 0L);

        long testID = file.getFileID();

        assertEquals(0L, testID, "Test ID should be 0L.");
    }
}