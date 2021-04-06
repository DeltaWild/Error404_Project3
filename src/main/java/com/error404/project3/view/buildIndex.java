package com.error404.project3.view;

import com.error404.project4.model.fileItem;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.error404.project3.view.MaintenanceGUI.maintDisplayTable;
import static com.error404.project3.view.fileList.fileInfo;

public class buildIndex {
    public buildIndex() throws IOException {
        maintDisplayTable.setBackground(Color.BLUE);
        MaintenanceGUI.window.repaint();
        FileWriter outFile = new FileWriter("engine.txt", StandardCharsets.UTF_8);
        for (fileItem file : fileInfo) {
            outFile.write(String.valueOf(file));
        }
    }
}
