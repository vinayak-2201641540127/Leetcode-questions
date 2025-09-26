class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int count=0;
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    int x = nums[i], y = nums[j], z = nums[k];
                    if(x+y<=z || x+z<=y || z+y<=x)break;
                    count++;
                }
            }
        }
        return count;
    }
}