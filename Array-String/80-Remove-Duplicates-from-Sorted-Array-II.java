// my code using two loop

class Solution {
    public int removeDuplicates(int[] nums) {
        int x = -11000;
        int ele = nums[0];
        int cnt = 1;
        int delete = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != ele) {
                cnt = 0;
                ele = nums[i];
            }
            if (cnt >= 2) {
                nums[i] = x;
                delete++;
            }
            cnt++;

        }
        int j = 1;

        for (int i = 1; i < nums.length-delete; i++) {
            if (nums[i] == x) {
                if(j<i) j=i;
                while (j < nums.length && nums[j] == x) {
                    j++;
                }
                if (j != nums.length) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        

        return nums.length - delete;
    }
}

// more optimize code

class Solution {
    public int removeDuplicates(int[] nums) {
        int i=2;
        for(int j=2;j<nums.length;j++){
            if(nums[j]!=nums[i-2]){
                nums[i] = nums[j];
                i++;
            }

        }
        return i;
    }
}