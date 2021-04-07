package com.error404.project4.model;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static com.error404.project3.view.fileList.fileInfo;

public class buildIndex {
    public buildIndex() throws IOException {
        Set<String> results = new HashSet<>(); // store words of file here

        FileWriter fw = new FileWriter("engine.txt", StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(fw);

        // Print file list
        /* ***** */
        for (fileItem file : fileInfo) { // for each file in fileInfo List:
            bw.write(file.fileID + "\t" +
                    file.fileName + "\t" +
                    file.fileSize + "\t" +
                    file.fileModDate + "\n"); // print the details of each file, one file per line
        }
        /* ***** */

        // Generate inverted index for each file
        for (fileItem file: fileInfo) { // for each file in fileInfo List:
            File path = new File(file.fileName); // associate file.fileName with File element for Scanner
            Scanner in = new Scanner(path); // Scanner to read file

            while (in.hasNext()) { // iterate over file
                results.add(in.next()); // add word to List
            }

            for (String result : results) { // for each word in List:
                bw.write(result + "\n"); // write word to output file followed by newline
            }
            in.close();
        }

        bw.close();
        fw.close();
    }
}
