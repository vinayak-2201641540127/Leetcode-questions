class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length+1];
        for(int []ar: dp){
            Arrays.fill(ar, -1);
        }
        // Arrays.fill(dp, -1);
        return f1(0,-1, nums);
    }

    public int f1(int i, int prev, int nums[]){
        if(i == nums.length){
            return 0;
        }
        if(dp[i][prev+1]!= -1)return dp[i][prev+1];
        int take = 0;
        int notTake = 0;
        if(prev == -1 || nums[prev]<nums[i]){
            take = 1+f1(i+1, i, nums);
        }
        notTake = f1(i+1, prev, nums);
        return dp[i][prev+1] = Math.max(take, notTake);
    }

}