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
    int t;
    int ans;
    public void inOrder(TreeNode root){
        if(root == null)return;
        inOrder(root.left);
        t--;
        if(t == 0){
            ans = root.val;
            return;
        }

        inOrder(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        t = k;
        inOrder(root);
        return ans;
    }
}