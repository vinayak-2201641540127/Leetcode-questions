class Solution {
    int m, n;
    int dir[][] = {
        {0, 1},{0, -1},{1, 0},{-1, 0}
    };
    public List<List<Integer>> pacificAtlantic(int[][] height) {
        m = height.length;
        n = height[0].length;
        List<List<Integer>>ans = new ArrayList<>();
        boolean pacific[][] = new boolean[m][n];
        boolean atlantic[][] = new boolean[m][n];

        for(int i=0; i<n; i++)f1(pacific, height, 0, i);
        for(int i=0; i<m; i++)f1(pacific, height, i, 0);
        for(int i=0; i<n; i++)f1(atlantic, height, m-1, i);
        for(int i=0; i<m; i++)f1(atlantic, height, i, n-1);

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(atlantic[i][j] && pacific[i][j]){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;

    }

    void f1(boolean vis[][], int height[][], int i, int j){
        if(vis[i][j])return;
        vis[i][j] = true;
        for(int d[]: dir){
            int nx = d[0]+i;
            int ny = d[1]+j;
            if(nx<0 || ny<0 || nx>=m || ny>=n)continue;
            if(height[nx][ny] < height[i][j])continue;
            f1(vis, height, nx, ny);
        }
    }

}