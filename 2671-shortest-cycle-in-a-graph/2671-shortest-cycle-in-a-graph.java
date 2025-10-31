class Solution {

    public int bfs(List<List<Integer>>adj, int src){
        int n = adj.size();
        Queue<Integer>queue = new LinkedList<>();
        queue.add(src);
        int dist[] = new int[n];
        int parent[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[src] = 0;
        int ans = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int neigh: adj.get(curr)){
                if(dist[neigh] == Integer.MAX_VALUE){
                    dist[neigh] = dist[curr]+1;
                    parent[neigh] = curr;
                    queue.offer(neigh);
                }else if(parent[neigh] != curr && parent[curr] != neigh){
                    ans = Math.min(ans, dist[curr]+dist[neigh]+1);
                }
            }
        }
        return ans;
    }

    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>>adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int []edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int ans = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            ans = Math.min(ans, bfs(adj, i));
        }
        return ans == Integer.MAX_VALUE?-1:ans;
    }
}