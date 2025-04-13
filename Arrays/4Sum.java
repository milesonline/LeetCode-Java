/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start

//Brute force solution using nested loops
//too slow has a 0(n^4) time complexity

/* 
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //Creating an output array to store the solution
        List<List<Integer>> output = new ArrayList<>();
        //sorting to help with avoiding duplicates
        Arrays.sort(nums);

        //our nested loops for array traversal
        for(int a = 0; a < nums.length-3; a++){
            //avoid duplicate scenario
            if(a > 0 && nums[a] == nums[a-1]) continue;
            for(int b = a + 1; b < nums.length-2; b++){
                //avoid duplicates
                if(b > a + 1 &&  nums[b] == nums[b-1]) continue;
                for(int c = b + 1; c < nums.length-1; c++){
                    //avoid duplicates
                    if(c > b + 1 && nums[c] == nums[c-1]) continue;
                    for(int d = c + 1; d < nums.length; d++){
                        //avoid duplicates
                        if(d > c + 1 && nums[d] == nums[d-1]) continue;
                        //set sum of all values
                        long sum = (long) nums[a] + nums[b] + nums[c] + nums[d];
                        //compare it to target
                        if(sum == target){
                            //store sum inside output
                            output.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        }
                    }
                }
            }
        }
        return output;
    }
}

*/

//Optimised solution
//O(n^3) time complexity as we loop 3 times


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target){
        //Create result array to store answer
        List<List<Integer>> result = new ArrayList<>();
        //store size of array
        int size = nums.length;
        //base case
        if(nums == null || size < 4){
            return result;
        }
        //Sort array to help avoid duplicates
        Arrays.sort(nums);
        // create outer for loops
        for(int i = 0; i < size - 3; i++){
            //avoid duplicates
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1; j < size - 2; j++){
                //avoid duplicate
                if(j > i + 1 && nums[j] == nums[j-1]) continue;
                //create pointers
                int left = j + 1;
                int right = size - 1;

                while(left < right){
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum == target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //avoid duplicates
                        while(left < right && nums[left] == nums[left+1]) left++;
                        while(left < right && nums[right] == nums[right-1]) right--;
                        
                        left++;
                        right--;
                    } else if(sum < target){
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end
