/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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
//time complexity = O(n)
class Solution {
    //Constant to indicate the tree is unbalanced
    final int UNBALANCED = -1;
    public boolean isBalanced(TreeNode root) {
        //a null tree is considered balanced
        return dfs(root) != UNBALANCED;
    }
    //helper method to return the height of the subtree
    //or -1 if it is unbalanced
    private int dfs(TreeNode root){
        //base case an empty subtree has height of 0
        if(root == null) return 0;

        //recursively check left subtree
        int leftH = dfs(root.left);
        if(leftH == UNBALANCED) return UNBALANCED;

        //recursively check right subtree
        int rightH = dfs(root.right);
        if(rightH == UNBALANCED) return UNBALANCED;

        //If difference in heights is more than 1, its unbalanced
        if(Math.abs(leftH - rightH) > 1) return UNBALANCED;

        //return height of the current node
        return Math.max(leftH, rightH) + 1;
    }
}
// @lc code=end


