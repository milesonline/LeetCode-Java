/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

// @lc code=start
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //store the original color
        int oldcolor = image[sr][sc];

        //edge case just incase the old color is already the new color
        if(oldcolor == color){
            return image;
        }

        //run dfs on the pixels surrounding the start pixel
        dfs(image, sr, sc, oldcolor, color);
        //return the result
        return image;
    }

    //build out dfs algorithm
    public void dfs(int[][] image, int i, int j, int oldcolor, int color){
        //base case if we are out of bounds
        if(i < 0 || i >= image.length || j < 0 || j>= image[i].length){
            return;
        }
        //base case if the pixel isnt the oldcolor no need to fill it
        else if(image[i][j] != oldcolor){
            return;
        }
        //change color of pixel
        else{
            image[i][j] = color;

            //traverse all 4 directions from pixel
            dfs(image, i+1, j, oldcolor, color); //down
            dfs(image, i-1, j, oldcolor, color); //up
            dfs(image, i, j+1, oldcolor, color); //right
            dfs(image, i, j-1, oldcolor, color); //left

        }
    }
}
// @lc code=end


