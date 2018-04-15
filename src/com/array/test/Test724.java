package com.array.test;

import java.util.ArrayList;
import java.util.List;

public class Test724 {
	
	public static void main(String[] args) {
		int nums[] = {1,-1,1};
		System.out.println(pivotIndex(nums));
	}
	/**
	 * 寻找中间数使得左右两边和相等
	 * 设置两个指针，分别从左右两边进行遍历
	 * @param nums
	 * @return
	 */
	public static int pivotIndex(int[] nums) {
		int i;
		int index = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (i = 0; i < nums.length; i++) {
			 int suml = 0;
			 int sumr = 0;
			 for (int left = 0; left <= i; left++) {
				 suml += nums[left];
			 }
			 for (int right = i; right < nums.length; right++) {
				 sumr += nums[right];
			 }
			 if (suml == sumr) {
				 list.add(i);
			 }
		}
		if (list.size() == 0)
			index = -1;
		else 
			index = list.get(0);
		return index;
    }
}
