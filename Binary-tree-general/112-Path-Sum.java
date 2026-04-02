class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // Check if it's a leaf node
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        targetSum -= root.val;

        return hasPathSum(root.left, targetSum) || 
               hasPathSum(root.right, targetSum);
    }
}