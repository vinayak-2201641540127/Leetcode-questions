class Solution {

    public int f1(int coins[], int amount){
        if(amount == 0)return 0;
        if(amount<0)return Integer.MAX_VALUE;
        int minCoins = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){
            int val = f1(coins, amount-coins[i]);
            if(val != Integer.MAX_VALUE){
                minCoins = Math.min(minCoins, 1+val);
            }
        }
        return minCoins;
    }

    public int f1_memo(int coins[], int amount, int dp[]){
        if(amount == 0)return 0;
        if(amount<0)return Integer.MAX_VALUE;
        if(dp[amount] != -1)return dp[amount];
        int minCoins = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){
            int val = f1_memo(coins, amount-coins[i], dp);
            if(val != Integer.MAX_VALUE){
                minCoins = Math.min(minCoins, 1+val);
            }
        }
        return dp[amount] = minCoins;
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // int ans = f1(coins, amount);
        int dp[] = new int[amount+1];
        Arrays.fill(dp, -1);
        // return ans == Integer.MAX_VALUE?-1:ans;
        int ans = f1_memo(coins, amount, dp);
        return ans == Integer.MAX_VALUE?-1:ans;
    }
}