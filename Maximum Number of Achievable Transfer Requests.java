class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[] balance = new int[n]; // Tracks the net change in employee transfers for each building
        int maxRequests = 0;

        // Generate all possible combinations of requests
        for (int i = 0; i < (1 << requests.length); i++) {
            // Reset the balance for each combination
            for (int j = 0; j < n; j++) {
                balance[j] = 0;
            }

            int currRequests = 0;
            boolean valid = true;

            // Process each request in the combination
            for (int j = 0; j < requests.length; j++) {
                if ((i & (1 << j)) != 0) { // Check if the jth request is included in the combination
                    int from = requests[j][0];
                    int to = requests[j][1];

                    balance[from]--; // Employee leaving the 'from' building
                    balance[to]++; // Employee moving to the 'to' building
                    currRequests++;
                }
            }

            // Check if the combination is valid
            for (int j = 0; j < n; j++) {
                if (balance[j] != 0) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                maxRequests = Math.max(maxRequests, currRequests);
            }
        }

        return maxRequests;
    }
}