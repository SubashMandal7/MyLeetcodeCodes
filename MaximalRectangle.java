class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            // Update the heights array based on the current row
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1')
                    heights[j] += 1;
                else
                    heights[j] = 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        int n = heights.length;
        int maxArea = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = -1;
        right[n - 1] = n;

        for (int i = 1; i < n; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i])
                p = left[p];
            left[i] = p;
        }

        for (int i = n - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < n && heights[p] >= heights[i])
                p = right[p];
            right[i] = p;
        }

        for (int i = 0; i < n; i++) {
            int area = heights[i] * (right[i] - left[i] - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}