class Solution {
    int cookies[];
    int sum[];
    int dist = Integer.MAX_VALUE;
    public int distributeCookies(int[] cook, int k) {
        cookies = cook;
        int n = cook.length;
        sum =  new int[k];
        dfs(0, k);
        return dist;
    }

    public void dfs(int index, int k){

        if(index == cookies.length){
            int max = 0;
            for(int i=0; i<sum.length; i++){
                max = Math.max(max, sum[i]);
            }
            dist = Math.min(dist, max);
            return;
        }

        for(int i=0; i<k; i++){
            sum[i] += cookies[index];
            dfs(index+1, k);
            sum[i] -= cookies[index];
        }
    }

}