package com.array.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test88 {

	public static void main(String[] args) {
		int nums1[] = {1,2,3,0,0,0};
		int nums2[] = {2,5,6};
		int m = 3;
		
		int n = nums2.length;
		merge(nums1, m, nums2, n);
	}
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		List <Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			list.add(nums1[i]);
		}
		for (int i = 0; i < n; i++) {
			list.add(nums2[i]);
		}
		Collections.sort(list);
		
		for (int i = 0;i < list.size(); i++) {
			nums1[i] = list.get(i);
		}
    }
}
