import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Problem 364 : Nested List Weight Sum II
 * 
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

Example 1:

Input: [[1,1],2,[1,1]]
Output: 8 
Explanation: Four 1's at depth 1, one 2 at depth 2.
Example 2:

Input: [1,[4,[6]]]
Output: 17 
Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.
 */
public class NestedListWeightSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	/*
	 * Solution 1: 
	 * Instead of multiplying by depth, add integers multiple times 
	 * (by going level by level and adding the unweighted sum to the weighted sum after each level).
	 * 
	 * Each integer get added one extra time for the mere existence of each one level under it.
	 * The concept of weight here is implemented with repeated addition;
	 */
	public int depthSumInverse(List<NestedInteger> nestedList) {
	    int unweighted = 0, weighted = 0;
	    while (!nestedList.isEmpty()) {
	        List<NestedInteger> nextLevel = new ArrayList<>();
	        for (NestedInteger ni : nestedList) {
	            if (ni.isInteger())
	                unweighted += ni.getInteger();
	            else
	                nextLevel.addAll(ni.getList());
	        }
	        // note: we DO NOT reset the unweighted total, so that keeps getting carried forward 
	        // which eventually means we keep adding previous numbers again and again.
	        weighted += unweighted;
	        nestedList = nextLevel;
	    }
	    return weighted;
	}

	/*
	 * Solution 2: Use the queue (BFS)
	 * Pretty much same as above, its just we use queue here
	 */
	public int depthSumInverse2(List<NestedInteger> nestedList) {
        int prevSum = 0;
        int totalSum = 0;
        Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        for (NestedInteger ni : nestedList) {
            queue.offer(ni);
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                NestedInteger current = queue.poll();
                if (current.isInteger()) {
                    levelSum += current.getInteger();
                } else {
                    for (NestedInteger ni: current.getList()) {
                        queue.offer(ni);
                    }
                }
            }
            prevSum += levelSum; // note we never reset prevSum, we only reset levelSum at every iteration of the loop
            totalSum += prevSum;
        }
        return totalSum;
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
