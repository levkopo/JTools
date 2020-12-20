package com.github.levkoposc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public final class FileTools {

    public String read(String path) {
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);

            StringBuilder output = new StringBuilder();
            while (myReader.hasNextLine())
                output.append(myReader.nextLine());

            myReader.close();
            return output.toString();
        }catch (Exception e){
            return null;
        }
    }

    public boolean isExists(String path){
        try {
            File myObj = new File(path);
            return myObj.exists();
        }catch (Exception e){
            return false;
        }
    }

    public boolean addToFile(String path, String str){
        String content = read(path);
        if(content==null)
            content = "";

        return write(path, content+str);
    }

    public boolean write(String path, String str) {
        try {
            File file = new File(path);
            if(!file.isFile()){
                boolean result = file.createNewFile();
                if(!result) return false;
            }

            FileWriter myWriter = new FileWriter(file);
            myWriter.write(str);
            myWriter.close();

            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
