package com.array.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test169 {
	
	public static void main(String[] args) {
		int nums[] = {-1,1,1,1,2,1};
		int x = majorityElement(nums);
		System.out.println(x);
	}
	public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		hashmap.put(nums[0], 1);
	
		for (int i = 1; i < nums.length; i++) {
			//System.out.println("存在的个数：" + hashmap.keySet().toString());
			Set<Integer> set = hashmap.keySet();
			if (set.contains(nums[i])) {
				int k = hashmap.get(nums[i]);
				//System.out.println("value =" + k);
				hashmap.put(nums[i], k + 1);
			}
			else {
				hashmap.put(nums[i], 1);
			}
		}
		
		//按照values值进行hashmap排序
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(hashmap.entrySet());  
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
			
		});
		int maxnum = list.get(0).getKey();
		return maxnum;
    }
}
