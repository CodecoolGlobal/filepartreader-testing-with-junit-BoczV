package com.codecool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {

    private FilePartReader fpr;

    public FilePartReader getFpr() {
        return fpr;
    }

    public void setFpr(FilePartReader fpr) {
        this.fpr = fpr;
    }

    public FileWordAnalyzer(FilePartReader fpr) {
        setFpr(fpr);
    }

    /**
     * Calls FilePartReader.readLines method and orders words alphabetically.
     * @return the words ordered by alphabetically as an ArrayList
     */
    public List getWordsOrderedAlphabetically(String filePath, int fromLine, int toLine) {
        String[] wordsList = splitWordsArrayFromFile(filePath, fromLine, toLine);
        ArrayList<String> alphabeticallyOrderedList = new ArrayList<>(Arrays.asList(wordsList));
        Collections.sort(alphabeticallyOrderedList);
        return alphabeticallyOrderedList;
    }

    /**
     * Calls FilePartReader.readLines method and returns the words which contains the subString.
     * @param subString - We will search for this pattern.
     * @return words which contains the subString.
     */
    public List getWordsContainingSubstring(String subString, String filePath, int fromLine, int toLine) {
        String[] wordsList = splitWordsArrayFromFile(filePath, fromLine, toLine);
        ArrayList<String> wordsWhichContainsSubstring = new ArrayList<>();
        for(int i = 0; i < wordsList.length; i++){
            if(wordsList[i].contains(subString)){
                wordsWhichContainsSubstring.add(wordsList[i]);
            }
        }
        return wordsWhichContainsSubstring;
    }

    /**
     * Calls FilePartReader.readLines method and returns the words from the String which are palindrome.
     * @return words from the String which are palindrome.
     */
    public List getStringsWhichPalindromes(String filePath, int fromLine, int toLine) {
        String[] wordsList = splitWordsArrayFromFile(filePath, fromLine, toLine);
        ArrayList<String> wordsWhichArePalindrome = new ArrayList<>();
        for (String word : wordsList) {
            StringBuilder strBuild = new StringBuilder();
            strBuild.append(word);
            strBuild = strBuild.reverse();
            if (word.contentEquals(strBuild) && !(word.matches("| |,"))) {
                wordsWhichArePalindrome.add(word);
            }
        }
        return wordsWhichArePalindrome;
    }

    private String[] splitWordsArrayFromFile(String filePath, int fromLine, int toLine){
        FilePartReader fpr = getFpr();
        String fineLinesFromFile = fpr.readLines(filePath, fromLine, toLine);
        return fineLinesFromFile.split(" ");
    }
}
