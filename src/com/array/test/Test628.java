package com.array.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test628 {
	public static void main(String[] args) {
		int nums[] = {4,0,0,4};
		System.out.println(maximumProduct(nums));
	}
	public static int maximumProduct(int[] nums) {
		int max = 0;
		List<Integer> positive  = new ArrayList();
		List<Integer> negative  = new ArrayList();
		if (nums.length == 3) {
			return max = nums[0]*nums[1]*nums[2];
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 0) {
				positive.add(nums[i]);
			}
			else
			{
				negative.add(nums[i]);
			}
		}
		int temp2 = 0;
		int temp1 = 0;
		Collections.sort(positive);
		if (negative.size() > 1) {
			if (positive.size() == 0) {
				return max = (negative.get(negative.size() - 1))*(negative.get(negative.size() - 2))*(negative.get(negative.size() - 3));
			}
			Collections.sort(negative);
			if (positive.size() == 1) {
				temp2 = (negative.get(0))*(negative.get(1));
				return max = (positive.get(positive.size() - 1))*temp2;
			}
			else {
				temp1 = (positive.get(positive.size() - 2))*(positive.get(positive.size() - 3));
				temp2 = (negative.get(0))*(negative.get(1));
				max = (positive.get(positive.size() - 1))*Math.max(temp1, temp2);
			}
			
		}
		else {//一负或者没有负数时
			return max = (positive.get(positive.size() - 2))*(positive.get(positive.size() - 3))*(positive.get(positive.size() - 1));
		}
        return max;
    }
	
	public static int maximumProduct2(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		int max = nums[n - 1] * nums[n - 2] * nums[n - 3];
		max = Math.max(max, nums[0] * nums[1] * nums[2]);
		max = Math.max(max, nums[n-1] * nums[0] * nums[1]);
		max = Math.max(max, nums[0] * nums[n-1] * nums[n-2]);
		return max;
	}
}
