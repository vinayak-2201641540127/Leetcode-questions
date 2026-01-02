class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n-3; i++){
            if(nums[i] == nums[i+1] || nums[i] == nums[i+2] || nums[i] == nums[i+3]){
                return nums[i];
            }
        }
        if(nums[n-1] == nums[n-2] || nums[n-1] == nums[n-3])return nums[n-1];
        if(nums[n-2] == nums[n-3])return nums[n-3];
        return -1;
    } 
}