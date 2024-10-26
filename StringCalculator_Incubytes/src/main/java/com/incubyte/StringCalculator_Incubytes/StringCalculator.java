package com.incubyte.StringCalculator_Incubytes;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null || numbers.trim().isEmpty()) {
            return 0;
        }

        String delimiter = "[,\n]";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        String[] nums = numbers.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String num : nums) {
            try {
                int parsedNum = Integer.parseInt(num.trim());
                if (parsedNum < 0) {
                    negatives.add(parsedNum);
                }
                sum += parsedNum;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input: '" + num + "' is not a valid integer.");
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
        }

        return sum;
    }
}

