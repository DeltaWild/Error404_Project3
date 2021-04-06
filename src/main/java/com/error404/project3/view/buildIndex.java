package com.error404.project3.view;

import com.error404.project4.model.fileItem;

import java.awt.*;
import java.io.*;

import static com.error404.project3.view.MaintenanceGUI.maintDisplayTable;
import static com.error404.project3.view.fileList.fileInfo;

public class buildIndex {
    public buildIndex() throws IOException {
        maintDisplayTable.setBackground(Color.BLUE);
        MaintenanceGUI.window.repaint();
        FileOutputStream fos = new FileOutputStream("engine.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (fileItem file : fileInfo) {
            oos.writeObject(file);
        }
        oos.close();
        fos.close();
    }
}
