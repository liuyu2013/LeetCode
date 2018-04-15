package com.array.test;

public class Test27 {

	public static void main(String[] args) {
		int nums[] = {2,2,3};
		System.out.println(removeElement(nums, 2));
	}
	public static int removeElement(int[] nums, int val) {
		if (nums.length == 0) 
			return 0;
		
		int count = 0;
		int temp = 0;
		int x = nums[0];
		int k = 0;
		for (int i = 0; i < nums.length && k != nums.length - 1; i++) {
        		if (nums[i] == val) {
        			x  = nums[i];
        			for (int j = i; j < nums.length - 1; j++) {
        				temp = nums[j];
        				nums[j] = nums[j+1];
        				nums[j+1] = nums[j];
        			}
        			nums[nums.length - 1] = x;
        			 i--;
        		}
        		k++;
        }
        for (int i = 0; i < nums.length; i++) {
        	System.out.println(nums[i]);
        		if (nums[i] != val) {
        			count++;
        			//
        		}
        }
        return count;
    }
}
