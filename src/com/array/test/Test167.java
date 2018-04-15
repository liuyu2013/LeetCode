package com.array.test;

import java.util.HashMap;

public class Test167 {

	public static void main(String[] args) {
		int test[] = {0,0,2,4};
		int target = 0;
		int index[] = new int[2];
		index = twoSum1(test,target);
		System.out.println(index[0] + " " + index[1]);
	}
	//1.时间超时
	public static int[] twoSum(int[] numbers, int target) {
		int []index = new int[2];
		boolean flag = true;
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if ((numbers[i] + numbers[j]) == target) {
					index[0] = i + 1;
					index[1] = j + 1;
					flag = false;
					break;
				}
			}
			if (!flag)
				break;
		}
        return index;
    }
	//2.复杂度O(n)，设置两个前后的指针，进行查找
	//双指针问题
	public static int[] twoSum1(int[] numbers, int target) {
		int []index = new int[2];
		int left = 0, right = numbers.length - 1;
		while (left < right) {
			if (numbers[left] + numbers[right] > target) {
				right--;
			}
			else if (numbers[left] + numbers[right] < target) {
				left++;
			}
			else {
				index[0] = left + 1;
				index[1] = right + 1;
				break;
			}
		}
		return index;
    }
}
