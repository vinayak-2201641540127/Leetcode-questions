class Solution {
    Map<Integer, List<Pair>> map;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        dfs(root, 0, 0);

        List<List<Integer>> ans = new ArrayList<>();
        for (int dist : map.keySet()) {
            List<Pair> list = map.get(dist);
            // Sort by level, then by value
            Collections.sort(list, (a, b) -> {
                if (a.level == b.level) return a.val - b.val;
                return a.level - b.level;
            });

            List<Integer> column = new ArrayList<>();
            for (Pair p : list) column.add(p.val);
            ans.add(column);
        }

        return ans;
    }

    public void dfs(TreeNode root, int dist, int level) {
        if (root == null) return;

        map.computeIfAbsent(dist, k -> new ArrayList<>())
           .add(new Pair(root.val, level));

        dfs(root.left, dist - 1, level + 1);
        dfs(root.right, dist + 1, level + 1);
    }
}

class Pair {
    int val, level;
    Pair(int v, int l) {
        val = v;
        level = l;
    }
}
