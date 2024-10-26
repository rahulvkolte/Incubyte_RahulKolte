package com.incubyte.StringCalculator_Incubytes;

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

        for (String num : nums) {
            try {
                sum += Integer.parseInt(num.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input: '" + num + "' is not a valid integer.");
            }
        }

        return sum;
    }
}

