package com.array.test;

import java.util.Arrays;

public class Test746 {
	//最小花费问题--可以同时走两步或者走一步--动态规划
	public static void main(String[] args) {
		int cost[] = {1,0,0,1};
		System.out.println(minCostClimbingStairs1(cost));
	}
	/**
	 * 部分问题无法出现正确答案---不知道哪里出了问题
	 * @param cost
	 * @return
	 */
	public static int minCostClimbingStairs(int[] cost) {
		//利用动态规划
		int price  = 0;
		if (cost.length == 1) {
			return cost[0];
		}
		
		if (cost.length == 2) {
			return Math.min(cost[0], cost[1]);
		}
		for (int i = 0; i < cost.length - 2;) {
			if (cost[i+1] < (cost[i]+cost[i+2])){
				price += cost[i+1];
				i = i + 1;
			}
			else {
				price += cost[i+2];
				i = i + 2;
			}
			System.out.println(price);
		}
        return price;
    }
	public static int minCostClimbingStairs1(int[] cost) {
		int mincost[] = new int[cost.length];
		mincost[0] = cost[0];
		mincost[1] = cost[1];
		
		for (int i = 2; i < mincost.length; i++) {
			mincost[i] = cost[i] + Math.min(mincost[i-1], mincost[i-2]);
		}
		System.out.println(Arrays.toString(mincost));
		return Math.min(mincost[cost.length - 1], mincost[cost.length - 2]);
	}
}
