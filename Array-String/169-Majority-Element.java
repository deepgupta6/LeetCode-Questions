class Solution {
    public int majorityElement(int[] nums) {
        int cnt =1;
        int num = nums[0];

        for(int i=1;i<nums.length;i++){
            if(cnt==0) num = nums[i];
            if(num==nums[i]) cnt++;
            else cnt--;
        }
        return num;
        
    }
}
