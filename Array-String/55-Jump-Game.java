class Solution {
    public boolean canJump(int[] nums) {
        int mi = 0;

        for(int i =0;i<nums.length && mi>=i;i++){
            if((nums[i]+i)>mi){
                mi = nums[i]+i;
            }
        }
        return mi>=nums.length-1;
    }
}