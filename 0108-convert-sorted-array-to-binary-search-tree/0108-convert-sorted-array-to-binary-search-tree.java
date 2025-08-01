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

    public TreeNode buildTree(int nums[], int left, int right){
        if(left>right)return null;
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left, mid-1);
        root.right = buildTree(nums, mid+1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        int beg = 0;
        int end = n-1;
        return buildTree(nums, beg, end);
        
    }
}