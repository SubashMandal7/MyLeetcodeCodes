class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: If both nodes are null, they are the same
        if (p == null && q == null) {
            return true;
        }

        // If one of the nodes is null and the other is not, they are different
        if (p == null || q == null) {
            return false;
        }

        // If the values of the current nodes are different, they are different trees
        if (p.val != q.val) {
            return false;
        }

        // Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
