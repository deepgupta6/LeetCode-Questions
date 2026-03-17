class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];

        List<List<Integer>> li = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                li.add(Arrays.asList(start, end));
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        li.add(Arrays.asList(start, end));
        int[][] ans = new int[li.size()][2];

        for (int i = 0; i < li.size(); i++) {
            ans[i][0] = li.get(i).get(0);
            ans[i][1] = li.get(i).get(1);
        }

        return ans;

    }
}