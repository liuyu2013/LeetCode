package com.array.test;

public class Test268 {
	public static void main(String[] args) {
		int nums[] = {1,3,0};
		System.out.println(missingNumber(nums));
	}
	public static int missingNumber(int[] nums) {
		int test[] = new int[nums.length + 1];
		for (int i = 0; i < test.length; i++) {
			test[i] = -1;
		}
		for (int i = 0; i < nums.length; i++) {
			test[nums[i]] = nums[i];
		}
		int miss = -1;
		for (int i = 0; i < test.length; i++) {
			if (test[i] == -1)
				miss = i;
		}
        return miss;
    }
}
