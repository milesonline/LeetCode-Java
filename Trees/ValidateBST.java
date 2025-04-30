/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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

 //Time complexity is O(n) since we only check each node once
 //Space complexity is O(h) in the worst case, the recursive call goes as deep as the height of the tree.
class Solution {
    public boolean isValidBST(TreeNode root) {
        //Start with full valid range of values
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    //Helper Method to validate the BST property using min and max bounds
    private boolean isValid(TreeNode node, long min, long max){
        //Base case: if we reach a null node, its valid
        if(node == null) return true;

        //The current nodes value must be strictly between min and max
        if(node.val <= min || node.val >= max) return false;

        //Recursively validate left and right subtrees
        //Left values must be less than node value
        //Right values must be more than node value
        return isValid(node.left, min, node.val) &&
               isValid(node.right, node.val, max);
    }
}
// @lc code=end
