package com.array.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test66 {

	public static void main(String[] args) {
		int [] digits = {9,9,1};
		System.out.println(Arrays.toString(plusOne(digits)));
	}
	/**
	 * 给定一个非负整数，将其当做一个包含数字的数组来看待对其“加一”后所得到的数组
	 * 进位问题，数组扩充问题
	 * @param digits
	 * @return
	 */
	public static int[] plusOne(int[] digits) {
		//int sum[] = new int[digits.length + 1];
		List<Integer> list  = new ArrayList<Integer>();
		int temp = 0;
		int flag = 0;
		
		for (int i = digits.length - 1; i >= 0; i--) {
			if (i == digits.length - 1) {
				temp = digits[i] + 1;
			}
			else {
				temp = digits[i] + flag;
			}
			if (temp > 9) {
				list.add(temp % 10);
				flag = 1;
			}
			else {
				list.add(temp);
				flag = 0;
			}
		}
		if (flag == 1) {
			list.add(1);
		}
		int sum[] = new int[list.size()];
		for (int i = 0; i < sum.length; i++) {
			sum[sum.length- 1 - i] = list.get(i);
		}
		//System.out.println(list.toString());
		//System.out.println(Arrays.toString(sum));
        return sum;
    }
}
