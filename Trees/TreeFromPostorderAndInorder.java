/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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

 //Time complexity is O(n)

class Solution {
    //Store inorder and postorder globally for easy access inside recursion
    int[] inOrder;
    int[] postOrder;
    //Map to quickly look up index of a value in inorder
    Map<Integer, Integer>  hm = new HashMap<>();
    //index in postorder, starting from the end (postorder ends with root)
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inOrder = inorder;
        postOrder = postorder;

        int n = inorder.length;
        index = n - 1; //Last element in postorder is the root

        //fill hashmap with value -> index mappings from inorder
        for(int i = 0; i < n; i++){
            hm.put(inorder[i], i);
        }

        //Start building the from full inorder range
        TreeNode root = dfs(0, n - 1);

        return root;
    }
    //Recursive helper to build subtree between start and end indices in inorder
    private TreeNode dfs(int start, int end){
        //base case: no elements to construct this subtree
        if(start > end) return null;

        //get the current root from postorder using current index
        int curVal = postOrder[index--];
        TreeNode cur = new TreeNode(curVal);

        //Finf the roots index in inorder using the hashmap
        int mid = hm.get(curVal);

        //important: Build right subtree first
        //Because we are going backwards in postorder, right subtree comes before the left
        cur.right = dfs(mid + 1, end);

        //build left subtree
        cur.left = dfs(start, mid - 1);
        //return the current root to be attached to its parent
        return cur;
    }
}
// @lc code=end


