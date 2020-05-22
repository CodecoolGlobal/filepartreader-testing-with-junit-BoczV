package com.codecool;

public class Main {
    public static void main(String[] args) {
        FilePartReader fpr = new FilePartReader();
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        /*fpr.setup("./src/main/resources/testFile", 1, 3);*/
    }
}
