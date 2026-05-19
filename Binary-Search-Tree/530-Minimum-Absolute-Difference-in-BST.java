class Solution {

    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        in(root, arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++) {
            min = Math.min(min, Math.abs(arr.get(i - 1) - arr.get(i)));
        }
        return min;
    }

    static void in(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }

        in(root.left, arr);
        arr.add(root.val);
        in(root.right, arr);
    }
}