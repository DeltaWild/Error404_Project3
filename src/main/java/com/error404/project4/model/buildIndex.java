package com.error404.project4.model;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static com.error404.project3.view.fileList.fileInfo;

public class buildIndex {
    HashMap<String, Set<posPair>> words = new HashMap<>();
    public buildIndex() throws IOException {

        FileWriter fw = new FileWriter("engine.txt", StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(fw);
        wordsInDocument();

        // Print file list
        for (fileItem file : fileInfo) { // for each file in fileInfo List:
            bw.write(file.fileID + "\t" +
                    file.fileName + "\t" +
                    file.fileSize + "\t" +
                    file.fileModDate + "\n"); // print the details of each file, one file per line
        }

        // Generate inverted index for each file (need to complete)
        for (Map.Entry<String, Set<posPair>> key : words.entrySet()) {
            bw.write(key.getKey() + ", " + key.getValue() + "\n"); // eliminated duplicates, working on k:v pair print
        }

        bw.close();
        fw.close();
    }

    public HashMap<String, Set<posPair>> wordsInDocument() throws IOException {

        for (fileItem file: fileInfo) { // for each file in fileInfo List:
            Scanner in = new Scanner(new File(file.fileName)); // Scanner to read file
            int position = 0;

            while (in.hasNext()) { // iterate over file
                String word = in.next().toLowerCase(); // convert word to lowercase (eliminate case dupes)
                posPair docPos = new posPair(file.fileID, position);
                if (!words.containsKey(word)) {
                    words.put(word, new TreeSet());
                }

                Set<posPair> pos = (Set)words.get(word);
                pos.add(docPos);
                position++;
            }
            in.close();
        }
        return words; // does it need to return? unsure of exact implementation right now
    }

    public String posPair(Long docID, int pos) {
        return "{" + docID + ", " + pos + "}";
        }

}
