/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
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
public class Codec {
    //Constant to represent nulls
    final String X = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //Base case for null node
        if(root == null) return X;
        //Serialize left subtree
        String left = serialize(root.left);
        //Serialize right subtree
        String right = serialize(root.right);
        //Preoroder: root, left, right
        return root.val + "," + left + "," + right;        
    }

    // Decodes your encoded data to tree. we split the string and consume it in preorder fashion
    String[] arr;
    int index = 0;
    public TreeNode deserialize(String data) {
        //split the serialized string into tokens
        arr = data.split(",");
        //Begin recursive tree reconstruction
        return dfs();
    }

    private TreeNode dfs() {
        //Base case: if value is equal to X its a null node
        if(arr[index].equals(X)){
            //move forward in the token list
            index++;
            return null;
        }

        //Create node with current value
        TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));

        //recurse for left and right subtrees
        root.left = dfs();
        root.right = dfs();

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

