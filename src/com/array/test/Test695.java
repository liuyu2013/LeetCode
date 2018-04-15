package com.array.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test695 {
	/**
	 * 题目：给定一个二维数组，找到垂直或水平方向连续1最多的个数，就是岛的面积
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String filepath = "src/data.txt";
			
		int[][] grid = new int[8][13];
		grid = FileIo.matrix(filepath,8,13);
		/*Scanner input = new Scanner(System.in);*/
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		int maxarea = 0;
		maxarea = maxAreaOfIsland(grid);
		System.out.println(maxarea);
	}
	/**
	 * 找到连续1的个数最多的序列
	 * 主要核心思想：将矩阵进行遍历，检测每一个点的四周
	 * @param grid
	 * @return
	 */
	public static int maxAreaOfIsland(int[][] grid) {
		int res  = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					res = Math.max(res, signalIsland(grid, i, j));
				}
			}
		}
        return res;
    }
	public static int signalIsland(int[][] grid, int r ,int c) {
		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length)
			return 0;
		int res = 0;
		if (grid[r][c] == 1) {
			grid[r][c] = 0;
			//左-上-右-下
			res = 1 + signalIsland(grid, r, c-1) + signalIsland(grid, r-1, c) + signalIsland(grid, r, c + 1) + 
					signalIsland(grid, r+1, c);
		}
		return res;
	}
}
