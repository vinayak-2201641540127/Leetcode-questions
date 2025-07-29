/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, Integer>map;
    int ans = 0;
    public void dfs(TreeNode root, int ind, int depth){
        if(root == null)return;
        map.computeIfAbsent(depth, k->ind);
        int width = ind-map.get(depth)+1;
        ans = Math.max(ans, width);
        dfs(root.left, 2*ind, depth+1);
        dfs(root.right, 2*ind+1, depth+1);
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)return 0;
        map = new HashMap<>();
        dfs(root, 0, 0);
        return ans;

    }
}