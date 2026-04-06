class Solution {
    public List<Double> averageOfLevels(TreeNode root) {

        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        List<Double> li = new ArrayList<>();

        while(!qu.isEmpty()){
            int size = qu.size();
            double sum = 0;

            for(int i = 0; i < size; i++){
                TreeNode curr = qu.poll();
                
                sum += curr.val;

                if(curr.left != null){
                    qu.offer(curr.left);
                }
                if(curr.right != null){
                    qu.offer(curr.right);
                }
            }

            li.add(sum / size);
        }

        return li;
    }
}