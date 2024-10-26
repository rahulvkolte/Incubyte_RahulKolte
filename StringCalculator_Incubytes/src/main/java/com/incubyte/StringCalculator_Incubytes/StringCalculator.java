package com.incubyte.StringCalculator_Incubytes;

public class StringCalculator {

	public int add(String numbers) {
		if (numbers == null || numbers.trim().isEmpty()) {
			return 0;
		}

		String[] nums = numbers.split(",");
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