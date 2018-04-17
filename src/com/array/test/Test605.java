package com.array.test;

import java.util.Arrays;

public class Test605 {
	public static void main(String[] args) {
		int flowerbed[] = {1,0,0,0,0,0,1};
		System.out.println(canPlaceFlowers(flowerbed, 2));

	}

	/**
	 * 走迷宫类似
	 * 
	 * @param flowerbed
	 * @param n
	 * @return
	 */
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		boolean flag = false;
		int left = 0, right = 0;
		int length = flowerbed.length;
		int count = 0;
		if (length > 1) {
			if (flowerbed[0] == 0 && flowerbed[1] == 0) {
				flowerbed[0] = 1;
				count++;
			}
			if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
				flowerbed[flowerbed.length - 1] = 1;
				count++;
			}
			for (int i = 1; i < flowerbed.length - 1; i++) {
				left = i - 1;
				right = i + 1;
				if (flowerbed[i] == 0 && flowerbed[left] == 0 && flowerbed[right] == 0) {
					flowerbed[i] = 1;
					count++;
				}
			}
		}
		else {
			if (flowerbed[0] == 0) {
				count = 1;
			}else {
				count = 0;
			}
		}
		if (count >= n) {
			flag = true;
		}else
			flag = false;

		return flag;
	}
}
