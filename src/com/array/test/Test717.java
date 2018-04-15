package com.array.test;

import java.util.ArrayList;
import java.util.List;

public class Test717 {
	//对于结尾字符串的判定-能够识别的编码为0,10,11--字符结尾是单独是0的--yes
	//若是10结尾的---no
	
	public static void main(String[] args) {
		int bits[] = {1,1,0};
		System.out.println(isOneBitCharacter(bits));
	}
	/**
	 * 单独设置识别0编码的为-1；
	 * 以11或者10识别的为-2；
	 * @param bits
	 * @return
	 */
	public static boolean isOneBitCharacter(int[] bits) {
        boolean flag = true;
        List<Integer> list = new ArrayList<Integer>();
        int k = 0;
        	for (int i = 0; i < bits.length;) {
        		if (bits[i] == 0) {
        			list.add(-1);
        			i++;
        		}
        		else {
        			i = i + 2;
        			list.add(-2);
        		}
        	}
        	k = list.size();
        	if (list.get(k-1) == -2)
        		flag = false;
        return flag;
    }
}
