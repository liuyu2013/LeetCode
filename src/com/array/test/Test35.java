package com.array.test;

public class Test35 {

	public static void main(String[] args) {
		int nums[] = {1,3,5,6};
		System.out.println(searchInsert(nums, 7));
	}
	/**
	 * 查找可能存在的索引位置
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int searchInsert(int[] nums, int target) {
        int index = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
        		if (nums[i] >= target) {
        			index = i;break;
        		}
        }
        index = i;
        return index;
    }
}
