import java.util.List;

/*
 * Problem 339 : Nested List Weight Sum
 * 
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: 10 
Explanation: Four 1's at depth 2, one 2 at depth 1.
Example 2:

Input: [1,[4,[6]]]
Output: 27 
Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
 */
public class NestedListWeightSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	/*
	 * The algorithm takes O(N) time, where N is the total number of nested elements in the input list. 
	 */
	public int depthSum(List<NestedInteger> nestedList) {
	    return depthSum(nestedList, 1);
	}

	public int depthSum(List<NestedInteger> list, int depth) {
	    int sum = 0;
	    for (NestedInteger n : list) {
	        if (n.isInteger()) {
	            sum += n.getInteger() * depth;
	        } else {
	            sum += depthSum(n.getList(), depth + 1);
	        }
	    }
	    
	    return sum;
	}

	// This is the interface that allows for creating nested lists.
	// You should not implement it, or speculate about its implementation
	interface NestedInteger {
		// @return true if this NestedInteger holds a single integer, rather
		// than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds
		// a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a
		// nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}
}
