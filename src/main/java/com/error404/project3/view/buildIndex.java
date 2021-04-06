package com.error404.project3.view;

import com.error404.project4.model.fileItem;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

import static com.error404.project3.view.MaintenanceGUI.maintDisplayTable;
import static com.error404.project3.view.fileList.fileInfo;

public class buildIndex {
    public buildIndex() throws IOException {
        maintDisplayTable.setBackground(Color.BLUE);
        MaintenanceGUI.window.repaint();
        FileWriter fw = new FileWriter("engine.txt", StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(fw);
        for (fileItem file : fileInfo) {
            bw.write(file.fileID + "\t" +
                    file.fileName + "\t" +
                    file.fileSize + "\t" +
                    file.fileModDate);
        }
        bw.close();
        fw.close();
    }
}
