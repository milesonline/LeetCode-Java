/*
 * @lc app=leetcode id=653 lang=java
 *
 * [653] Two Sum IV - Input is a BST
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
    public boolean findTarget(TreeNode root, int k) {
        //Create an array list to store the values of the BST
        List<Integer> nums = new ArrayList<>();
        //Sort the BST using inorder traversal which is a recursive DFS method that returns BSTs in ascending order
        inorder(root, nums);
        //Create Two Pointers to find the value pairs that add to k
        int left = 0;
        int right = nums.size()-1;
        //Iterate through values in array List
        while(left < right){
            if(nums.get(left) + nums.get(right) == k) return true;
            else if(nums.get(left) + nums.get(right) < k) left++;
            else{
                right--;
            }
        }
        return false;
    }
    //Inorder traversal method
    public void inorder(TreeNode root, List<Integer> nums){
        //base case if the current node is null, stop recursion (no more nodes to process)
        if(root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}
// @lc code=end
