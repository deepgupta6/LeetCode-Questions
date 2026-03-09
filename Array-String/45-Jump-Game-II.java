import java.util.Arrays;

public class Solution {
    int n;
    int[] dp;

    public int solve(int[] nums, int i) {
        if (i >= n - 1)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int res = Integer.MAX_VALUE;

        for (int x = 1; x <= nums[i]; x++) {
            if (i + x < n) {
                int next = solve(nums, i + x);
                if (next != Integer.MAX_VALUE)
                    res = Math.min(res, next + 1);
            }
        }

        return dp[i] = res;
    }

    public int jump(int[] nums) {
        n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(nums, 0);
    }
} 


// optimized version

class Solution2 {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if(i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}
