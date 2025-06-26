package com.codingdojo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberParser {
    protected static final String NUMBER_STR_1 =
                    "   \n" +
                    "  |\n" +
                    "  |";
    protected static final String NUMBER_STR_2 =
                    " _ \n" +
                    " _|\n" +
                    "|_ ";
    protected static final String NUMBER_STR_3 =
                    " _ \n" +
                    " _|\n" +
                    " _|";
    protected static final String NUMBER_STR_4 =
                    "   \n" +
                    "|_|\n" +
                    "  |";
    protected static final String NUMBER_STR_5 =
                    " _ \n" +
                    "|_ \n" +
                    " _|";
    protected static final String NUMBER_STR_6 =
                    " _ \n" +
                    "|_ \n" +
                    "|_|";
    protected static final String NUMBER_STR_7 =
                    " _ \n" +
                    "  |\n" +
                    "  |";
    protected static final String NUMBER_STR_8 =
                    " _ \n" +
                    "|_|\n" +
                    "|_|";
    protected static final String NUMBER_STR_9 =
                    " _ \n" +
                    "|_|\n" +
                    " _|";
    protected static final String NUMBER_STR_0 =
                    " _ \n" +
                    "| |\n" +
                    "|_|";
    protected static final Map<String, String> numberMap = new HashMap<>();

    static {
                numberMap.put(NUMBER_STR_0.trim(), "0");
                numberMap.put(NUMBER_STR_1.trim(), "1");
                numberMap.put(NUMBER_STR_2.trim(), "2");
                numberMap.put(NUMBER_STR_3.trim(), "3");
                numberMap.put(NUMBER_STR_4.trim(), "4");
                numberMap.put(NUMBER_STR_5.trim(), "5");
                numberMap.put(NUMBER_STR_6.trim(), "6");
                numberMap.put(NUMBER_STR_7.trim(), "7");
                numberMap.put(NUMBER_STR_8.trim(), "8");
                numberMap.put(NUMBER_STR_9.trim(), "9");
    }

    public static String parseNumber(String numberStr) {
        return numberMap.getOrDefault(numberStr.trim(), "5");
    }

    public static String[] splitStringToStringNumbers(String code) {
        String[] numbers = {"","","","","","","","",""};
        int iteration = 0;
        for (int j = iteration; j < 3; j++) {
            for (int i = 0; i < 27; i = i + 3) {
                int indexStart = j * 27 + i;
                int indexEnd = j * 27 + i + 3;
                String substring = code.substring(indexStart, indexEnd);
                numbers[i/3] +=  substring.lastIndexOf('\n') == -1 &&  j != 2
                        ? substring + "\n"
                        : substring;
            }
        }
        return numbers;
    }

    public static int splitStringToNumbers(String code) {
        String[] numbers = splitStringToStringNumbers(code);
        String parcedNumberStr = Arrays.stream(numbers)
                .map(NumberParser::parseNumber)
                .reduce("", String::concat);
        return Integer.parseInt(parcedNumberStr);
    }
}
