package com.array.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test448 {
	/**
	 * 查找缺失的数据
	 * @param args
	 */
	public static void main(String[] args) {
		int []nums = {4,3,2,7,8,2,3,1};
		List<Integer> list = new ArrayList<Integer>();
		list = findDisappearedNumberscorrect(nums);
		System.out.println(list);
	}
	/**
	 * 因为不允许开辟新的空间，所以遍历一遍数据，将遍历过的数字，对应位置的数字置位负数，则最后剩下的正数则为所求的i
	 * @param nums
	 * @return
	 */
	public static List<Integer> findDisappearedNumberscorrect(int[] nums) {
		
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int index  = Math.abs(nums[i]) - 1;
			if(nums[index] > 0) {
				nums[index] = -nums[index];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				list.add(i + 1);
		}
		return list;
	}
	/**
	 * 该方法时间超时
	 * @param nums
	 * @return
	 */
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
        		if (!list.contains(nums[i])) {
        			list.add(nums[i]);
        		}
        }
        System.out.println(list);
        int k = list.size();
        for (int i = 1; i < nums.length + 1; i++) {
        		if (!list.contains(i)) {
        			list.add(i);
        		}
        }
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()){
            int b = iter.next();
            if(k != 0){
                iter.remove();
                k--;
            }
        }
        return list;
    }
}
