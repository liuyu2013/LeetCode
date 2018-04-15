package com.array.test;

import java.util.Arrays;

public class Test53 {

	public static void main(String[] args) {
		int nums[] = {-1,-2};
		System.out.println(maxSubArray(nums));
	}
	//最长子串和---动态规划
	public static int maxSubArray(int[] nums) {
		
		int sum = Integer.MIN_VALUE;
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {
			temp += nums[i];
			if (sum < temp) {
				sum = temp;
			}
			if (temp < 0) {//以免把负数加进去
				temp = 0;
			}
		}
        return sum;
    }
}
