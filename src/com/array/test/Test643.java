package com.array.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Maximum Average Subarray I-----最长子串和 dp[i]表示以第i个元素结尾的子串的最大和的值
 * dp[i]的来源可能是：dp[i-1]+x[i] or x[i] 转移状态：dp[i]=max(dp[i-1]+x[i],x[i]);
 * 
 * @author mac
 *
 */
public class Test643 {

	public static void main(String[] args) {
		int nums[] = { 0, 1, 1, 3, 3 };
		System.out.println(findMaxAverage(nums, 5));
	}

	public static double findMaxAverage(int[] nums, int k) {
		// int dp[] = new int[nums.length];
		int sum = 0;
		int maxsum = Integer.MIN_VALUE;
		if (k == nums.length) {
			maxsum = 0;
			for (int i = 0; i < nums.length; i++)
				maxsum += nums[i];
			return (double) maxsum / (double) k;
		}
		for (int i = 0; i < nums.length - k + 1; i++) {
			sum = 0;
			for (int j = i; j < k + i; j++) {
				sum += nums[j];
			}
			maxsum = Math.max(maxsum, sum);
		}
		System.out.println(maxsum);
		return (double) maxsum / (double) k;
	}

	public static double findMaxAverage_best(int[] nums, int k) {
		if (nums == null || nums.length < k)
			return 0.0;
		int sum = 0;
		int res = Integer.MIN_VALUE;
		int left = 0, right = 0;
		while (right < nums.length) {
			sum += nums[right];
			right++;
			if (right - left == k) {
				res = Math.max(sum, res);
				sum -= nums[left];
				left++;
			}
		}
		return (double) res / k;
	}
}
