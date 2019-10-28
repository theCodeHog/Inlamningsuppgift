package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * <h2>File Utilities</h2>
 * Contains static methods that are used to read and save files in the Magic Store Program.
 */
public interface FileUtils {

    //METHODS ----------------------------------------------------------------

    public static List<String> readAllLines(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static List readObjects(String fileName){
        ObjectInputStream objectinputstream = null;
        List listItems = null;
        try {
            FileInputStream streamIn = new FileInputStream(fileName);
            objectinputstream = new ObjectInputStream(streamIn);
            listItems = (List) objectinputstream.readObject();
            objectinputstream .close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listItems;
    }

    public static void writeObjects(ArrayList myList, String fileName){
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream(fileName, true);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(myList);
            objectOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
