package com.array.test;

import java.util.HashSet;

public class Test217 {

	public static void main(String[] args) {
		int nums[] = {1,2,3,2,1};
		System.out.println(containsDuplicate(nums));
	}
	public static boolean containsDuplicate(int[] nums) {
		boolean flag = true;
		int i = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for (i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		if (set.size() == nums.length)
			flag = false;
		return flag;
    }
}
