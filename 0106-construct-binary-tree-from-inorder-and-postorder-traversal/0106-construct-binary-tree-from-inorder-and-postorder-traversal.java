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
    public TreeNode buildTree(int inorder[], int postorder[], int left, int right, int []postIndex){
        if(left>right)return null;
        int val = postorder[postIndex[0]];
        postIndex[0]--;
        int index = map.get(val);
        TreeNode root = new TreeNode(val);
        root.right = buildTree(inorder, postorder, index+1, right, postIndex);
        root.left = buildTree(inorder, postorder, left, index-1, postIndex);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(inorder[i], i);
        }
        int postIndex[] = new int[1];
        postIndex[0] = n-1;
        return buildTree(inorder, postorder, 0, n-1, postIndex);
    }
}