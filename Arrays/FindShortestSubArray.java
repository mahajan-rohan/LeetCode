
/*
697. Degree of an Array
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:

Input: nums = [1,2,2,3,1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:

Input: nums = [1,2,2,3,1,4,2]
Output: 6
Explanation: 
The degree is 3 because the element 2 is repeated 3 times.
So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 

Constraints:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999. */


import java.util.HashMap;
import java.util.Map;
public class FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        // number -> [count, firstIndex, lastIndex]
        Map<Integer, int[]> map = new HashMap<>();
        int degree = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (!map.containsKey(num)) {
                map.put(num, new int[]{1, i, i});
            } else {
                int[] data = map.get(num);
                data[0]++;        // count
                data[2] = i;     // last index
            }

            degree = Math.max(degree, map.get(num)[0]);
        }

        int minLen = nums.length;

        for (int[] data : map.values()) {
            if (data[0] == degree) {
                minLen = Math.min(minLen, data[2] - data[1] + 1);
            }
        }

        return minLen;
    }
}
