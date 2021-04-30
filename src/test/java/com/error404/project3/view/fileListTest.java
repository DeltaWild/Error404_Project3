package com.error404.project3.view;

import com.error404.project4.model.fileItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class fileListTest {

    @Mock
    fileItem fileItemMock;

    @Test
    @DisplayName("Adding file properly appends file object to list with correct file ID.")
    void addFile() {
        when(fileItemMock.getFileID())
                .thenReturn(SearchGUI.idNumber++);

        fileList.fileInfo.add(fileItemMock);

        assertEquals(0, fileItemMock.getFileID(), "Test ID should be 0.");
    }
}