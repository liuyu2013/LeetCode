package com.array.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIo {
	
	public static int[][]matrix(String filepath, int m, int n) throws IOException{
		//String filepath = "src/data.txt";
		FileInputStream fis = new FileInputStream(filepath);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		int[][] nums = new int[m][n];
		String temp = br.readLine();
		int k = 0;
		while (temp != null) {
			String[] temparray = temp.split(",");
			for (int j = 0; j < n; j++) {
				nums[k][j] = Integer.valueOf(temparray[j]);
			}
			k++;
			temp = br.readLine();
		}
		return nums;
	}	
}
