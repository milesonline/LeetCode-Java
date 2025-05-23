/*
 * @lc app=leetcode id=226 lang=java
 *
 * [226] Invert Binary Tree
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

 //time complexity O(n)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        //base case return null if root is null
        if(root == null) return null;

        //Swap nodes
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //traverse tree
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
// @lc code=end


