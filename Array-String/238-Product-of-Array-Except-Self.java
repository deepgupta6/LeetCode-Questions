class Solution {
    public int[] productExceptSelf(int[] nums) {
        long product = 1;
        boolean zero = false;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 && zero == false) {
                zero = true;
            } else {
                product *= nums[i];
            }
        }
 
        for (int i = 0; i < n; i++) {
            if (zero == true && nums[i] != 0) {
                nums[i] = 0;
            } else if (nums[i] == 0) {
                nums[i] = (int) product;
            } else {
                int x = nums[i];
                nums[i] = (int) product / x;
            }
        }

        return nums;

    }
}

// without division operator

class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }

        int r = 1;

        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= r ;
            r *= nums[i];
        }

        return ans;

    }
}