package com.array.test;

import java.util.ArrayList;
import java.util.List;import javax.sound.midi.Track;

public class Test118 {
	public static void main(String[] args) {
		System.out.println(generate(0));
	}
	/**
	 * 输出黄金三角
	 * @param numRows
	 * @return
	 */
	public static List<List<Integer>> generate(int numRows) {
		List<Integer> temp = new ArrayList<Integer>();
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		if (numRows == 0) {
			return triangle;
		}
		temp.add(0, 1);
		triangle.add(0, temp);
		if (numRows == 1) {
			return triangle;
		}
		temp = new ArrayList<Integer>();
		temp.add(0,1);
		temp.add(1,1);
		triangle.add(1, temp);
		
        for (int i = 2; i < numRows; i++) {
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
        return triangle;
    }
}
