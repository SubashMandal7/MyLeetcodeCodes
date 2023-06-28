class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n]; // Array to store the multiplication result

        // Multiply each digit of num1 with num2 and accumulate the results
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                int product = digit1 * digit2;

                int sum = result[i + j + 1] + product; // Add the product to the current digit position
                result[i + j + 1] = sum % 10; // Store the least significant digit
                result[i + j] += sum / 10; // Carry-over the remaining value
            }
        }

        // Build the final result string
        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            if (!(sb.length() == 0 && digit == 0)) { // Ignore leading zeroes
                sb.append(digit);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}