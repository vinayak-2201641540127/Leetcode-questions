class Solution {

    public void dfs(char grid[][], int r, int c){
        int dirx[] = {0, 1, -1, 0};
        int diry[] = {1, 0, 0, -1};
        for(int i=0; i<4; i++){
            int nr = r+dirx[i];
            int nc = c+diry[i];
            if(nr<0 || nc<0 || nr>=grid.length || nc>=grid[0].length)continue;
            if(grid[nr][nc] == '1'){
                grid[nr][nc] = '0';
                dfs(grid, nr, nc);
            }

        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}