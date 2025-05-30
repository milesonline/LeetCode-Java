/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    //this will store all valid paths that sum to the target
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //If the tree is empty, return an empty list of paths
        if(root == null) return res;

        //start the dfs traversal from the root with an empty path
        dfs(root, targetSum, new LinkedList<>());
        //return the list of all valid paths
        return res;
    }

    //helper method to perform dfs traversal
    private void dfs(TreeNode root, int targetSum, List<Integer> path){
        //subtract the current nodes value from the remaining targetSum
        targetSum -= root.val;
        //add the current nodes value to the path
        path.add(root.val);
        //base case, if weve reached a leaf node and the remaining targetsum is 0
        if(root.left == null && root.right == null && targetSum == 0){
            //Make a copy of the current path and add it to the result list
            res.add(new LinkedList<>(path));
        }else {
            //recursive case, explore left subtree if it exists
            if(root.left != null){
                dfs(root.left, targetSum, path);
            }
            //do the same for right
            if(root.right != null){
                dfs(root.right, targetSum, path);
            }
        }
        //backtrack: remove the last node added to the path
        //to explore new paths in future recursive calls
        path.remove(path.size() - 1);
    }
}
// @lc code=end


