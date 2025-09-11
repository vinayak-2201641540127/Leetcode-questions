class Solution {

    public int dfs(int nums[], int multipliers[], int i, int l, int r, Map<String, Integer>map){
        if(i == multipliers.length)return 0;
        if(l>r)return 0;
        String s = i+""+l+""+r;
        if(map.containsKey(s))return map.get(s);
        int first = multipliers[i]*nums[l]+dfs(nums, multipliers, i+1, l+1, r, map);
        int second = multipliers[i]*nums[r]+dfs(nums, multipliers, i+1, l, r-1, map);
        map.put(s, Math.max(first, second));
        return map.get(s);
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length; 
        int m = multipliers.length;
        // int dp[][][] = new int[m][n][n];
        Map<String, Integer>map = new HashMap<>();
        // for(int i=0; i<m; i++){
        //     for(int ar[]: dp[i]){
        //         Arrays.fill(ar, -1);
        //     }
        // }
        return dfs(nums, multipliers, 0, 0, n-1, map);
    }
}