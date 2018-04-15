package com.array.test;

import java.io.IOException;
import java.util.Scanner;

public class Test485 {
	public static final int M = 2;
	public static final int N = 1;

	public static void main(String[] args) throws IOException {
		String filepath = "src/data.txt";
		int[] num = new int[N];
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < N; i++) {
			num[i] = input.nextInt();
		}
		System.out.println(findMaxConsecutiveOnes(num));
	}
	/**
	 * 
	 * @param nums
	 * @return 最长子串1的个数
	 */
	public static int findMaxConsecutiveOnes(int[] nums) {
		int max = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				count++;
			}
			else {
				if (count > max) 
					max = count;
				count = 0;
			}
		}
		return Math.max(count, max);
	}
}
