class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];  // Color array to track node states
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isSafe(graph, i, colors))
                safeNodes.add(i);
        }

        return safeNodes;
    }

    private boolean isSafe(int[][] graph, int node, int[] colors) {
        if (colors[node] != 0) {
            return colors[node] == 2;  // Return true if already visited and confirmed safe
        }

        colors[node] = 1;  // Mark node as visited (part of a potential cycle)

        for (int neighbor : graph[node]) {
            if (!isSafe(graph, neighbor, colors))
                return false;  // Unsafe node found, propagate false
        }

        colors[node] = 2;  // Mark node as visited and confirmed safe
        return true;
    }
}