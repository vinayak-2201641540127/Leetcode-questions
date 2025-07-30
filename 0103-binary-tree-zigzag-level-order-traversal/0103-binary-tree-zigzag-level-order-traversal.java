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
    List<List<Integer>>ans;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode root, int level){
        if(root == null)return;
        if(level == ans.size())ans.add(new ArrayList<>());
        if(level % 2 == 0){
            ans.get(level).add(root.val);
        }else{
            ans.get(level).add(0, root.val);
        }
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }




}