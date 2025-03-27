/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start

//Using pointers
//When the array is sorted, think of using pointers.
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int a_pointer = 0; //beginning of array
        int b_pointer = numbers.length-1; //end of array

        while(a_pointer <= b_pointer){
            //add the sum of the value at each pointer
            int sum = numbers[a_pointer] + numbers[b_pointer];
            //check this sum value against target
            //if the sum is less than target, move the first pointer forward so it is at a larger number
            if(sum < target){
                a_pointer++;
            }
            //iif the sum is greater than the target, move the far pointer back so it is at a smaller number
            else if(sum > target){
                b_pointer--;
            }
            //else if they are equal, return the indices of the pointer values + 1
            else{
                return new int[] {a_pointer+1, b_pointer+1};
            }   
        }
        return new int[] {a_pointer+1, b_pointer+1};
    }

}
// @lc code=end


