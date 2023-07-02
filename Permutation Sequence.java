class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        // Create a list of numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // Calculate factorial values for later use
        calculateFactorial(factorial, n);

        // Adjust k to be zero-based index
        k--;

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }

        return sb.toString();
    }

    private void calculateFactorial(int[] factorial, int n) {
        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            factorial[i] = i * factorial[i - 1];
        }
    }
}
