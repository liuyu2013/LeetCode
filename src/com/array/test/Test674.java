package com.array.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Test674 {
	
	public static void main(String[] args) {
		int nums[] = {1,3,5,4,7};
		System.out.println(findLengthOfLCIS1(nums));
	}
	/**
	 * 最长递增连续子序列---动态规划
	 * @param nums
	 * @return
	 */
	public static int findLengthOfLCIS(int[] nums) {
		if (nums.length == 1) {
			return 1;
		}
		if (nums.length == 0) {
			return 0;
		}
		HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
		int count = 1;
		int k = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i+1]) {
				count++;
				hashmap.put(k, count);
			}else
			{
				count = 1;
				k++;
				hashmap.put(k,count);
			}
		}
		/*for (int key: hashmap.keySet()) {
			int value = hashmap.get(key);
			System.out.println(key + " " + value);
		}*/
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(hashmap.entrySet());  
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
			
		});
		int maxnum = list.get(0).getValue();
        return maxnum;
    }

	public static int findLengthOfLCIS1(int[] nums) {
		//用来存放动态规划区间使用的数组
		if (nums.length == 0) {
			return 0;
		}
		int dp[] = new int[nums.length];
		dp[0] = 1;
		int max = dp[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i-1]) {
				dp[i] = dp[i-1] + 1;
				max = Math.max(max, dp[i]);
			}
			else {
				dp[i] = 1;
			}
		}
		//System.out.println(Arrays.toString(dp));
		return max;
	}
}
