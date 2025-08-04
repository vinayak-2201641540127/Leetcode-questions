class Solution {

    public boolean dfs(boolean vis[], boolean found[], List<List<Integer>>adj, int src){
        vis[src] = true;
        found[src] = true;
        for(int i: adj.get(src)){
            if(!vis[i]){
                if(dfs(vis, found, adj, i))return true;
            }else if(found[i])return true;
        }

        found[src] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        boolean vis[] = new boolean[numCourses];
        boolean found[] = new boolean[numCourses];

        for(int []pre: prerequisites){
            adj.get(pre[0]).add(pre[1]);
        }

        for(int i=0; i<vis.length; i++){
            if(!vis[i]){
                if(dfs(vis, found,  adj, i))return false;
            }
        }
        return true;



    }
}