/*
 * Problem 152: Maximum Product Subarray
 * 
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 */
public class MaximumProductSubarray {

	public static void main(String[] args) {
		int max = maxProduct(new int[]{-2,3,-4});
		System.out.println(max);
	}
	
	/*
	 * Solution: (dp)
	 * This is similar to maximum subarray. 
	 * Instead of sum, the sign of number affect the product value.
	 * When iterating the array, each element has two possibilities: positive number or negative number. 
	 * We need to track a minimum value, so that when a negative number is given, it can also find the maximum value. 
	 * We define two local variables, one tracks the maximum and the other tracks the minimum.
	 */
	public static int maxProduct(int[] nums) {
		int[] max = new int[nums.length];
	    int[] min = new int[nums.length];
	 
	    max[0] = min[0] = nums[0];
	    int result = nums[0];
	 
	    for(int i=1; i<nums.length; i++){
	        if(nums[i]>0){
	            max[i]=Math.max(nums[i], max[i-1]*nums[i]);
	            min[i]=Math.min(nums[i], min[i-1]*nums[i]);
	        }else{
	            max[i]=Math.max(nums[i], min[i-1]*nums[i]);
	            min[i]=Math.min(nums[i], max[i-1]*nums[i]);
	        }
	 
	        result = Math.max(result, max[i]);
	    }
	 
	    return result;
    }

}
