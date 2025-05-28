/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
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
    //variable to keep track of max diameter
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        //start dfs traversal
        dfs(root);
        //return max
        return max;
    }

    //helper method to help perform dfs traversal
    private int dfs(TreeNode node){
        //base case if the current node is null the height is 0
        if(node == null) return 0;
        
        //calculate the height of the left subtree
        int left = dfs(node.left);

        //do the same for the right sub tree
        int right = dfs(node.right);

        //the diameter at this node is the sum of the left and right subtrees
        //update max if this value is greater than the current max
        max = Math.max(max, left + right);

        //return the height of this subtree to the previous level in the recursion
        //the height is the max of left and right subtree heights plus the current node
        return Math.max(left, right) + 1;
    }
}
// @lc code=end

