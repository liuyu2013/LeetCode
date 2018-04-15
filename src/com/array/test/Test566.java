package com.array.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test566 {

	public static final int M = 2;
	public static final int N = 2;

	public static void main(String[] args) throws IOException {
		// 进行矩阵的重组
		String filepath = "src/data.txt";
		FileInputStream fis = new FileInputStream(filepath);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		int[][] nums = new int[M][N];
		String temp = br.readLine();
		int k = 0;
		while (temp != null) {
			String[] temparray = temp.split(" ");
			for (int j = 0; j < N; j++) {
				nums[k][j] = Integer.valueOf(temparray[j]);
			}
			k++;
			temp = br.readLine();
		}
		
		Scanner input = new Scanner(System.in);
		int r = input.nextInt();
		int c = input.nextInt();
		
		int[][] test = matrixReshape(nums, r, c);
		print(test);
	}

	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		 int n = nums.length;
		 int m = nums[0].length;
		 int[][] target = new int[r][c];
	     if (m * n != r*c)
			return nums;
	     /*for (int i = 0; i < r*c; i++) {
	    	 	 target[i/c][i%c] = nums[i/m][i%m];
	     }*/
	     //全部转换为链式
	     List<Integer> list = new ArrayList<Integer>();
	     for (int i = 0; i < n; i++) {
	    	 	for (int j = 0; j < m; j++)
	    	 		list.add(nums[i][j]);
	     }
	     System.out.println(list.toString());
	     int k = 0;
	     for (int i = 0; i < r; i++) {
	    	 	for (int j = 0; j < c; j++) {
	    	 		target[i][j] = list.get(k);
	    	 		k++;
	    	 	}
	     }
	     return target;
	 }
	public static void print (int[][] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				System.out.print(nums[i][j]);
			}
			System.out.println();
		}
	}
}
