package com.array.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test561 {
	/*
	 * Input: [1,4,3,2] Output: 4 Explanation: n is 2, and the maximum sum of pairs
	 * is 4 = min(1, 2) + min(3, 4).
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int maximum  = 0;
		int n = input.nextInt();
		int nums[] = new int[2*n];
		for(int i = 0; i < 2*n; i++)
			nums[i] = input.nextInt();
		Arrays.sort(nums);
		int size  = nums.length;
		for(int i = 0; i < nums.length; i++) {
			maximum += Math.min(nums[i],nums[i++]);	
		}
		System.out.println(maximum);
	}	
}
