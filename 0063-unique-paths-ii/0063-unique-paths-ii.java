class Solution1 {
    int r, c;
    public int f1(int [][]obs, int i, int j){
        if(i == r-1 && j == c-1)return 1;
        if(i >= r || j >= c)return 0;
        if(obs[i][j] == 1)return 0;
        int down = f1(obs, i+1, j);
        int right = f1(obs, i, j+1);
        return down+right;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        r = obstacleGrid.length;
        c = obstacleGrid[0].length;
        if(obstacleGrid[r-1][c-1] == 1)return 0;
        return f1(obstacleGrid, 0, 0);
    }
}

//top-down-memoization
class Solution2 {
    int r, c;
    int dp[][];
    public int f1(int [][]obs, int i, int j){
        if(i == r-1 && j == c-1)return 1;
        if(i >= r || j >= c)return 0;
        if(obs[i][j] == 1)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        int down = f1(obs, i+1, j);
        int right = f1(obs, i, j+1);
        return dp[i][j] = down+right;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        r = obstacleGrid.length;
        c = obstacleGrid[0].length;
        dp = new int[r][c];
        for(int ar[]: dp){
            Arrays.fill(ar, -1);
        }
        if(obstacleGrid[r-1][c-1] == 1)return 0;
        return f1(obstacleGrid, 0, 0);

    }
}

//bottom-up
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(obstacleGrid[n-1][m-1] == 1)return 0;
        int [][]dp = new int[n][m];
        dp[0][0] = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(obstacleGrid[i][j] == 1)dp[i][j] = 0;
                else{
                    if(i>0)dp[i][j] += dp[i-1][j];
                    if(j>0)dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
}
