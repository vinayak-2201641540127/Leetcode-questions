class Solution {
    Set<Integer>set;
    Map<List<Integer>, Boolean>map;
    public boolean canCross(int[] stones) {
        if(stones[1] != 1)return false;
        int n = stones.length;
        map = new HashMap<>();
        set = new HashSet<>();
        for(int i: stones){
            set.add(i);
        }
        return dfs(stones[n-1], 1, 1);
    }

    public boolean dfs(int target, int i, int jump){
        if(i == target){
            return true;
        }

        // if(dp[i][jump] != false)return dp[i][jump];
        // Pair p = new Pair(i, jump);
        List<Integer>l = new ArrayList<>(Arrays.asList(i, jump));
        if(map.containsKey(l)){
            if(map.get(l) == true)return true;
            return false;
        }

        List<Integer>lst = new ArrayList<>(Arrays.asList(jump-1, jump, jump+1));
        for(int next: lst){
            if(next>0 && set.contains(next+i)){
                if(dfs(target, i+next, next)){
                    map.put(l, true);
                    return true;
                }
            }
        }
        map.put(l, false);
        return false;
    } 

}
