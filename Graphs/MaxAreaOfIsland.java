/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */

// @lc code=start
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        ///store max area
        int max_area = 0;

        //traverse entire grid
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                //start dfs if you find a 1
                if(grid[i][j] == 1){
                max_area = Math.max(max_area, dfs(grid, i, j));
                }
            }
        }
        return max_area;
    }

    //helper dfs fucnction that returns area of island
    public int dfs(int[][] grid, int i, int j){
        //base case, if we go out of bounds or reach warter
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0){
            return 0;
        }

        //mark cureent cell as visited by setting it to 0
        grid[i][j] = 0;

        //count current cell + recursively check 4 directions

        return 1 
           + dfs(grid, i+1, j)
           + dfs(grid, i-1, j)
           + dfs(grid, i, j+1)
           + dfs(grid, i, j-1);
    }
}
// @lc code=end


