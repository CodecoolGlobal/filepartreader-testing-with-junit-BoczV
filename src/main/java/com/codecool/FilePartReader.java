package com.codecool;


import java.io.*;


public class FilePartReader {

    /**
     * Setup the flow.
     * @param filePath - File's path, we will find file with this.
     * @param fromLine - Line number which will be the first.
     * @param toLine  - Line number which will be the last.
     */
    public void setup(String filePath, int fromLine, int toLine) {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException();
        }
        String searchedLines = readLines(filePath, fromLine, toLine);
        System.out.println(searchedLines);
    }

    /**
     * Opens the file on filePath, and gives back it's content as a String.
     * @return all lines from file.
     */
    public String read(String filePath) {
        try {
            InputStream inputStream = new FileInputStream(filePath);
            InputStreamReader inputReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputReader);
            StringBuilder stringBuffer = new StringBuilder();
            String resultString;
            while((resultString = reader.readLine())!= null){
                stringBuffer.append(resultString + " 123");
            }
            return stringBuffer.toString();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * It gives back every line from it's content between fromLine and toLine (both of them are included),
     * and returns these lines as a String. Take care because if fromLine is 1, it means the very first row in the file.
     * Also, if fromLine is 1 and toLine is 1 also, we will read only the very first line.
     * @return proper lines from File.
     */
    public String readLines(String filePath, int fromLine, int toLine) {
        String fileContent = read(filePath);
        String[] wordsList = fileContent.split("123");
        String resultLines = "";
        for(int i = fromLine - 1; i < toLine; i++){
            resultLines += wordsList[i];
        }
        return resultLines;
    }
}
