package com.array.test;

public class Test122 {
	public static void main(String[] args) {
		
	}
	/**
	 * 应用贪婪算法：
	 * 1.从第一个元素开始遍历至最后一个元素；
	 * 2.若下一个元素比当前元素大，那么就抛售，并以下一个元素的价钱买入，同时累加利润。
	 * 3.若下一个元素比当前元素小，那么就以下一个元素的价钱买入（若连续出现递减的情况，那么最后的买入价格是最后那个最小的元素）；
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if (prices.length == 0) return 0;
		int buy_in = prices[0], sum = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > buy_in) {
				sum += prices[i] - buy_in;
				buy_in = prices[i];
			}
			else {
				buy_in = prices[i];
			}
		}
        return 0;
    }
}
