package com.array.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Test766 {
	public static final int M = 3;
	public static final int N = 4;

	public static void main(String[] args) throws Exception {
		String filepath = "src/data.txt";
		FileInputStream fis = new FileInputStream(filepath);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		int[][] matrix = new int[M][N];
		// 数据初始化
		int k = 0;
		String temp = br.readLine();
		while (temp != null) {
			String[] temparray = temp.split(" ");
			for (int j = 0; j < N; j++) {
				matrix[k][j] = Integer.valueOf(temparray[j]);
			}
			k++;
			temp = br.readLine();
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				// matrix[i][j] = Integer.valueOf(temparray[j]);
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		// 核心代码
		boolean flag = true;
		int count = 0;
		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = 0; j < matrix[i].length - 1; j++) {
				if (matrix[i][j] == matrix[i + 1][j + 1]) {
					count++;
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
			if (!flag) {
				break;
			} else
				continue;
		}
		System.out.println(count);
		if (flag)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
