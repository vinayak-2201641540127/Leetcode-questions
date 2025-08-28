class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int i=0, j=0;
        int n = grid.length;
        int m = grid[0].length;
        int r=0, c=0;
        while(r<n){
            List<Integer>lst = new ArrayList<>();
            i = r; j = c;
            while(i<n && j<m){
                lst.add(grid[i][j]);
                i++;
                j++;
            }
            Collections.sort(lst);
            Collections.reverse(lst);
            i=r;j=c;
            int k=0;
            while(i<n && j<m){
                grid[i][j] = lst.get(k++);
                i++;j++;
            }
            r++;
            // System.out.println(lst);
        }

        c=1;
        r=0;
        while(c<m){
            List<Integer>lst = new ArrayList<>();
            i = r; j = c;
            while(i<n && j<m){
                lst.add(grid[i][j]);
                i++;
                j++;
            }
            Collections.sort(lst);
            // Collections.reverse(lst);
            i=r;j=c;
            int k=0;
            while(i<n && j<m){
                grid[i][j] = lst.get(k++);
                i++;j++;
            }
            c++;
            // System.out.println(lst);
        }
        return grid;
    }
}