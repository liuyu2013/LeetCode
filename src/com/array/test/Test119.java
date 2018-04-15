package com.array.test;

import java.util.ArrayList;
import java.util.List;

public class Test119 {
	public static void main(String[] args) {
		int rowIndex = 0;
		System.out.println(getRow(rowIndex));
	}
	
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> temp = new ArrayList<Integer>();
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		
		temp.add(0, 1);
		triangle.add(0, temp);
		if (rowIndex == 0) {
			return temp;
		}
		temp = new ArrayList<Integer>();
		temp.add(0,1);
		temp.add(1,1);
		if (rowIndex == 1) {
			return temp;
		}
		triangle.add(1, temp);
		
        for (int i = 2; i < rowIndex+1; i++) {
        		temp = new ArrayList<Integer>();
        		temp.add(0, 1);
        		for (int j = 1; j < i; j++) {
        			 int x = triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j);
        			// System.out.println(x);
        			temp.add(j, x);
        		}
        		temp.add(i, 1);
        		triangle.add(i, temp);
        }
        return temp;
    }
}
