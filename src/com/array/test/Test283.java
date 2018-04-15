package com.array.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test283 {
	/**
	 * 将0的位置按照顺序移动到最后面
	 * @param args
	 */
	public static void main(String[] args) {
		int nums[] = new int[5];
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < nums.length; i++) {
			nums[i] = input.nextInt();
		}
		moveZeroes(nums);
	}
	public static void moveZeroes(int nums[]) {
		int[] temp = new int[nums.length];
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				temp[k] = nums[i];
				k++;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (i < k)
				nums[i] = temp[i];
			else
				nums[i] = 0;
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}
