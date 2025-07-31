class Solution {
    String tile;
    int sum = 0;
    public int numTilePossibilities(String tiles) {
        sum = 0;
        tile = tiles;
        char ch[] = tiles.toCharArray();
        Arrays.sort(ch);
        tile = new String(ch);
        int n = tiles.length();
        boolean status[] = new boolean[n]; 
        dfs(status);
        return sum;
    }

    public void dfs(boolean status[]){
        for(int i=0; i<status.length; i++){
            if(i>0 && tile.charAt(i) == tile.charAt(i-1) && !status[i-1])continue;
            if(status[i] == true)continue;
            status[i] = true;
            sum += 1;
            dfs(status);
            status[i] = false;
        }
        return;
    }
}