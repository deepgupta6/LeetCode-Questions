/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> qu = new LinkedList<>();

        qu.offer(root);
        int rev = 0;

        while (!qu.isEmpty()) {

            int size = qu.size();
            List<Integer> li = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = qu.poll();
                li.add(curr.val);

                if (curr.left != null)
                    qu.offer(curr.left);
                if (curr.right != null)
                    qu.offer(curr.right);

            }
            if (rev % 2 == 1) {
                Collections.reverse(li);
            }
            rev++;
            res.add(li);
        }

        return res;
    }
}