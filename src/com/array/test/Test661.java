package com.array.test;

import java.util.Arrays;

public class Test661 {

	public static void main(String[] args) {
		int M[][] = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
		int temp[][];
		temp = imageSmoother(M);
		for (int i = 0; i < temp.length ; i++)
		System.out.println(Arrays.toString(temp[i]));
 	}
	/**
	 * 旨在处理边界
	 * @param M
	 * @return
	 */
	public static int[][] imageSmoother(int[][] M) {
		
		int temp[][] = new int[M.length][M[0].length];
		if (M.length == 1 && M[0].length == 1) {
			temp[0][0] = M[0][0];
			return temp;
		}
		//处理一行数据
		if (M.length == 1) {
			temp[0][0] = (M[0][0] + M[0][1]) / 2;
			temp[0][M[0].length - 1] = (M[0][M[0].length - 1] + M[0][M[0].length - 2]) / 2;
			for (int j = 1; j < M[0].length - 1; j++) {
				temp[0][j] = (M[0][j] + M[0][j-1] + M[0][j+1]) / 3;
			}
			return temp;
		}
		//处理一列数据
		if (M[0].length == 1) {
			temp[0][0] = (M[0][0] + M[1][0]) / 2;
			temp[M.length - 1][0] = (M[M.length - 1][0] + M[M.length - 2][0]) / 2;
			for (int i = 1; i < M.length - 1; i++) {
				temp[i][0] = (M[i][0] + M[i-1][0] + M[i+1][0]) / 3;
			}
			return temp;
		}
		//处理4个角上数据
		int i = 0, j = 0;
		i = 0; j = 0;
		temp[i][j] = (M[0][0] + M[0][1] + M[1][1] + M[1][0]) / 4;
		
		i = M.length - 1; j = M[0].length - 1;
		temp[i][j] = (M[i][j] + M[i-1][j] + M[i-1][j-1] + M[i][j-1]) / 4;
		
		i = 0; j = M[0].length - 1;
		temp[i][j] = (M[i][j] + M[i][j-1] + M[i+1][j-1] + M[i+1][j]) / 4;

		i = M.length - 1;j = 0;
		temp[i][j] = (M[i][j] + M[i-1][j] + M[i-1][j+1] + M[i][j+1]) / 4;
		//处理最上面一行
		for (i = 0, j = 1; j < M[0].length - 1; j++) {
			temp[i][j] = (M[i][j] + M[i][j-1] + M[i][j+1] + M[i+1][j-1] + M[i+1][j] + M[i+1][j+1]) / 6;
		}
		//处理最下面一行
		for (i = M.length -1, j = 1; j < M[0].length - 1; j++) {
			temp[i][j] = (M[i][j] + M[i][j-1] + M[i][j+1] + M[i-1][j-1] + M[i-1][j] + M[i-1][j+1]) / 6;
		}
		//处理最左边一列
		for (j = 0, i = 1; i < M.length - 1; i++) {
			temp[i][j] = (M[i][j] + M[i-1][j] + M[i-1][j+1] + M[i][j+1] + M[i+1][j+1] + M[i+1][j]) / 6;
		}
		//处理最右边一列
		for (j = M[0].length - 1, i = 1; i < M.length - 1; i++) {
			temp[i][j] = (M[i][j] + M[i-1][j] + M[i-1][j-1] + M[i][j-1] + M[i+1][j-1] + M[i+1][j]) / 6;
		}
		//处理中间
		for (i = 1; i < M.length - 1; i++) {
			for (j = 1; j < M[0].length - 1; j++) {
				temp[i][j] = (M[i][j] + M[i-1][j] + M[i-1][j+1] + M[i][j+1] + M[i+1][j+1] + M[i+1][j] + M[i+1][j-1] + M[i][j-1]
						+ M[i-1][j-1]) / 9;
			}
		}
        return temp;
    }
}
