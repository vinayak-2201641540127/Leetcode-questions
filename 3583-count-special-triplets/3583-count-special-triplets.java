class Solution {
    public int specialTriplets(int[] nums) {

        Map<Integer, Integer>prefix = new HashMap<>();
        Map<Integer, Integer>suffix = new HashMap<>();
        int mod = (int)(Math.pow(10, 9)+7);
        int n = nums.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            suffix.put(nums[i], suffix.getOrDefault(nums[i], 0)+1);
        }
        for(int i: nums){
            suffix.put(i, suffix.get(i)-1);
            int val = i*2;
            ans = (int)((ans+1L*prefix.getOrDefault(val, 0)*suffix.getOrDefault(val, 0))%mod);
            prefix.put(i, prefix.getOrDefault(i, 0)+1);
        }
        return ans;
    }
}