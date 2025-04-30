/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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

 //Time Complexity is O(H + k)
 //Space complexity (O(H)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        //Stack to simulate inorder traversal iteratively
        Stack<TreeNode> stack = new Stack<>();

        //Continue until we have no unfinished nodes to process
        while(root !=null || !stack.isEmpty()){
            //reach rhe leftmost node of the current subtree
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            //process the leftmost node
            root = stack.pop();
            //Decrement k and if it becomes 0, it means weve found out k-th smallest element
            if(--k == 0){
                return root.val;
            }
            //Move to right subtree to continue the process
            root = root.right;
        }
        //if k is not valid, return 0 as default value
        return 0;
    }
}
// @lc code=end

