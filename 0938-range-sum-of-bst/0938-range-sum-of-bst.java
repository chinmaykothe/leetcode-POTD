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
    public void dfs(TreeNode root, int min, int max, int[] sum){
        if(root==null)
            return;
        if(root.val >= min && root.val <= max)
            sum[0] += root.val;
        dfs(root.left, min, max, sum);
        dfs(root.right, min, max, sum);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] sum = new int[1];
        dfs(root, low, high, sum);
        return sum[0];
    }
}