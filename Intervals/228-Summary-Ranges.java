class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ls = new ArrayList<>();
        if(nums.length==0) return ls;
        int x = nums[0];
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        boolean range = false;

        for (int i = 1; i < nums.length; i++) {
            if (x + 1 != nums[i]) {
                if (range == false) {
                    ls.add(sb.toString());
                } else {
                    sb.append("->" + x);
                    ls.add(sb.toString());
                }
                sb.setLength(0);
                sb.append(nums[i]);
                x = nums[i];
                range = false;
            } else {
                range = true;
                x++;
            }
        }

        if (range) {
            sb.append("->" + x);
        }
        ls.add(sb.toString());
        return ls;
    }
}