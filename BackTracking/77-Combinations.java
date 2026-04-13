class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        helper(n, k, 1, li);
        return res;

    }

    public void helper(int n, int k, int start, List<Integer> li) {
        if (li.size() == k) {
            res.add(new ArrayList<>(li));
            return;
        }

        for (int i = start; i <= n; i++) {
            li.add(i);
            helper(n, k, i + 1, li);
            li.remove(li.size() - 1);
        }

        return;
    }
}