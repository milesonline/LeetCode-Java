/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //start helper with indices for preorder and inorder
        return helper(0, 0, inorder.length-1, preorder, inorder);
    }

    //helper function to recursively build tree
    //prestart - current index in preorder array (root of current subtree)
    //instart and inend - current range in inorder array
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        //base case, if we have gone past the end of preorder or the inorder range is invalid
        if (preStart > preorder.length-1 || inStart > inEnd) return null;

        //the first element in preorder is always the root of the current subtree
        TreeNode root =  new TreeNode(preorder[preStart]);

        //find the index of the root value in the inorder array
        //this will help split the inorder array into left and right subtrees
        int inIndex = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(root.val == inorder[i]){
                inIndex = i;
            }
        }

        //build the left subtree
        //preorder[preStart + 1] is the next root(left child in preorder traversal)
        //inorder range becomes form inStart to inIndex - 1
        root.left = helper(preStart + 1, inStart, inIndex-1, preorder, inorder);

        //build the right subtree
        //for preorder index, skip over all left subtree nodes (inIndex - inStart),
        //add 1 to get to the right childs root
        root.right = helper(preStart + inIndex - inStart + 1, inIndex+1, inEnd, preorder, inorder);

        //return the built root
        return root;
    }
}
// @lc code=end

