class Solution {
    public int minFallingPathSum(int[][] mat) {
        int n = mat.length;
        int min = Integer.MAX_VALUE;
        int dp[][] = new int[n][n];
        for(int ar[]: dp){
            Arrays.fill(ar, Integer.MAX_VALUE);
        }
        for(int i=0; i<n; i++){
            min = Math.min(min, dfs(mat, 0, i, dp));
        }
        return min;
    }

    public int dfs(int mat[][], int i, int j, int dp[][]){
        if(i == mat.length-1)return mat[i][j];
        if(dp[i][j]!=Integer.MAX_VALUE)return dp[i][j];
        int dl=Integer.MAX_VALUE, d=Integer.MAX_VALUE, dr=Integer.MAX_VALUE;
        if(j>0)dl = dfs(mat, i+1, j-1, dp);
        d = dfs(mat, i+1, j, dp);
        if(j<mat.length-1)dr = dfs(mat, i+1, j+1, dp);
        return dp[i][j] = Math.min(dl, Math.min(dr, d))+mat[i][j];
    }

}