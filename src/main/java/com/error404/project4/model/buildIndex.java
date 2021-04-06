package com.error404.project4.model;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static com.error404.project3.view.fileList.fileInfo;

public class buildIndex {
    public buildIndex() throws IOException {
        FileWriter fw = new FileWriter("engine.txt", StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(fw);

        // Print file list
        /* ***** */
        for (fileItem file : fileInfo) {
            bw.write(file.fileID + "\t" +
                    file.fileName + "\t" +
                    file.fileSize + "\t" +
                    file.fileModDate + "\n");
        }
        /* ***** */

        // Generate inverted index for each file
        for (fileItem file: fileInfo) {
            FileReader fr = new FileReader(file.fileName);
            BufferedReader br = new BufferedReader(fr);



            br.close();
            fr.close();
        }

        bw.close();
        fw.close();
    }
}
