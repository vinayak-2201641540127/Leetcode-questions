class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int i=-1;
        int j=0;
        while(j<n){
            if(nums[j] == 1){
                if(i == -1){
                    i = j;
                }else{
                    int len=j-i;
                    if(len<=k)return false;
                    i=j;
                }
            }
            j++;
        }       
        return true;
    }
}