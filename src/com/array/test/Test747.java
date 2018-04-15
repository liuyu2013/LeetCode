package com.array.test;

import java.util.Arrays;

public class Test747 {

	public static void main(String[] args) {
		int nums[] = {3, 6, 1, 0};
		System.out.println(dominantIndex(nums));
	}
	
	public static int dominantIndex(int[] nums) {
		int maxnum = -1;
		int index = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > maxnum) {
				maxnum = nums[i];
				index = i;
			}
		}
		//Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (index != i && maxnum < nums[i]*2) 
				return -1;
		}
        return index;
    }
}
