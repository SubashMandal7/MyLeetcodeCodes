class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        // Step 1: Build parent map
        buildParentMap(root, null, parentMap);

        // Step 2: Perform DFS from target node
        dfs(target, k, parentMap, result, null);

        return result;
    }

    // Helper function to build the parent map
    private void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null)
            return;

        parentMap.put(node, parent);
        buildParentMap(node.left, node, parentMap);
        buildParentMap(node.right, node, parentMap);
    }

    // Helper function to perform DFS from the target node
    private void dfs(TreeNode node, int k, Map<TreeNode, TreeNode> parentMap, List<Integer> result, TreeNode prev) {
        if (node == null)
            return;

        if (k == 0) {
            result.add(node.val);
            return;
        }

        if (node.left != prev) {
            dfs(node.left, k - 1, parentMap, result, node);
        }

        if (node.right != prev) {
            dfs(node.right, k - 1, parentMap, result, node);
        }

        TreeNode parent = parentMap.get(node);
        if (parent != prev) {
            dfs(parent, k - 1, parentMap, result, node);
        }
    }
}