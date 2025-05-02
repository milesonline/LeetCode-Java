/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //time complexity is O(n)
 //space complexity is O(h)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Base case if the root is null return null
        //Weve reached a leaf nodes child
        if(root == null) return null;

        //if the current node is p or q we return it
        if(root == p || root == q) return root;

        //recursively search the left and right subtrees for p and q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //if both left and right calls return not null then p and q are in different branches
        //so the current node is the LCA
        if(left != null && right != null) return root;

        //else if only the left returns not null then both are in the left subtree
        if(left != null) return left;
        //else return right
        return right;
    }
}
// @lc code=end

