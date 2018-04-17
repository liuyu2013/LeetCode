package com.array.test;

import java.util.HashMap;

public class Test219 {

	public static void main(String[] args) {
		int nums[] = {1,0,1,1};
		System.out.println(containsNearbyDuplicate1(nums, 1));
	}
	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	//超时
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		boolean flag = false;
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == nums[i]) {
					temp = j - i;
					if (temp <= k) {
						flag = true;
						break;
					}
				}
			}
			if (flag) break;
		}
        return flag;
    }
	/**最佳答案
	 * Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(i>k){
                set.remove(nums[i-k-1]);
            }
            if(!set.add(nums[i]))return true;
            else set.add(nums[i]);
        }
        return false;
	 * @param nums
	 * @param k
	 * @return
	 */
	//利用hashmap进行数据的存储----解除一个for循环
	public static boolean containsNearbyDuplicate1(int[] nums, int k) {
		boolean flag = false;
		int temp = 0;
		HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				temp = i - map.get(nums[i]);
				if (temp <= k) {
					return true;
				}
				else {
					map.replace(nums[i], i);
				}
			}
			else {
				map.put(nums[i], i);
			}
		}
        return flag;
    }
}
