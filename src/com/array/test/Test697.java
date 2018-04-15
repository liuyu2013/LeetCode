package com.array.test;
/**
 * 更简单的方法：定义HashMap<Integer, int[]> map = new HashMap<>();
 * int[3],表示int[0]--firstIndex;，int[1]--lastIndex,int[2]出现的次数
 * 第二次遍历：当key (num) 的次数等于最大次数的时候，记录最小的长度。(lastIndex - firstIndex + 1)。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Test697 {
	public static void main(String[] args) {
		int nums[] = {1, 2, 2, 3, 1};
		System.out.println(findShortestSubArray(nums));
	}
	/**
	 * 找到数组的子串中和该数组的度相同的最短数组的长度
	 * @param nums
	 * @return
	 */
	public static HashSet<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		hashmap.put(nums[0], 1);
	
		for (int i = 1; i < nums.length; i++) {
			Set<Integer> set = hashmap.keySet();
			if (set.contains(nums[i])) {
				int k = hashmap.get(nums[i]);
				hashmap.put(nums[i], k + 1);
			}
			else {
				hashmap.put(nums[i], 1);
			}
		}
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(hashmap.entrySet());  
		HashSet<Integer> maxnums = new HashSet<Integer>();
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
			
		});
		int degree = list.get(0).getValue();//获得最大次数
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getValue() == degree)
				maxnums.add(list.get(i).getKey());
		}
		//int maxnum = list.get(0).getKey();//获得出现最大次数的元素
		return maxnums;
    }
	public static int findShortestSubArray(int[] nums) {
		int minlength = 0;
		HashSet<Integer> maxnums = new HashSet<Integer> ();
		List<Integer> distance = new ArrayList<Integer> ();
		maxnums = majorityElement(nums);
		for (int maxnum: maxnums) {
			distance.add(getdistance(maxnum, nums));
		}
		Collections.sort(distance);
		minlength = distance.get(0);
		
        return minlength;
    }
	public static int getdistance(int maxnums, int nums[]) {
		int l = 0, r = 0, distance = 0;
		for (l = 0; l < nums.length; l++) {
			if (nums[l] == maxnums)
				break;
		}
		for (r = nums.length - 1; r >= 0; r--) {
			if (nums[r] == maxnums)
				break;
		}
		distance  = r - l;
		return distance + 1;
	}
}
