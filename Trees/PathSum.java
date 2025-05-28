/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
 */

// @lc code=start
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //base case if tree is empty return false
        if(root == null) return false;

        //if leaf node, check if the value equals the targetSum
        if(root.left == null && root.right == null){
            return targetSum == root.val;
        }

        //subtract the current nodes value from the target sum and recurse
        int remaining = targetSum - root.val;

        //check left and right subtrees
        return hasPathSum(root.left, remaining)|| hasPathSum(root.right, remaining);
    }
}
// @lc code=end

