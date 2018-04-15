package com.array.test;

public class Test121 {

	public static void main(String[] args) {
		int prices[] = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit(prices));
	}
	public static int maxProfit(int[] prices) {
		
		if (prices.length == 0)	{
			return 0;
		}
		int minprice = prices[0];
		int maxprofit =  0;
		
		for (int i = 1; i < prices.length; i++) {
			if (minprice > prices[i]) {
				minprice = prices[i];
			}else
			{
				maxprofit = Math.max(maxprofit, prices[i] - minprice);
			}
		} 
		return maxprofit; 
    }
}
