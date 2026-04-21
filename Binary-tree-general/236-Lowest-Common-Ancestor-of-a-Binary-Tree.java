class Solution {
    TreeNode res;
    TreeNode p;
    TreeNode q;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        res = null;
        helper(root);
        return res;
    }

    public boolean helper(TreeNode root) {
        if (root == null) return false;

        boolean left = helper(root.left);
        boolean right = helper(root.right);
        boolean mid = (root == p || root == q);

        if ((mid && left) || (mid && right) || (left && right)) {
            res = root;
        }

        return mid || left || right;
    }
}