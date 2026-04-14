class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, used, new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, boolean[] used, List<Integer> li) {
        if (li.size() == nums.length) {
            res.add(new ArrayList<>(li));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            li.add(nums[i]);

            helper(nums, used, li);

            li.remove(li.size() - 1);
            used[i] = false;
        }
    }
}