package com.array.test;

/**
 * 只使用一个额外空间来删除冗余元素
 * 
 * @author mac
 *
 */
public class Test26 {

	public static void main(String[] args) {
		int nums[] = {1};
		System.out.println(removeDuplicates(nums));
	}

	public static int removeDuplicates(int[] nums) {
		int flag = Integer.MIN_VALUE;
		int length = 0;

		for (int i = 0; i < nums.length; i++) {
			
		    if (nums[i] == flag) { length = i; break; }
		    else {
		    		length++;
		    }
			for (int j = i + 1; j < nums.length;) {
				if (nums[j] == nums[i]) {
					nums[j] = flag;
					for (int k = j; k < nums.length - 1; k++) {
						nums[k] = nums[k+1];
					}
					nums[nums.length - 1] = flag;
				}
				else {
					j++;
				}
			}
		}
		return length;
		/*
		 * if(nums == null || nums.length == 0)
            return 0;
        int pre = nums[0];
        int size = 1;
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            if(pre == num)
                continue;
            nums[size++] = num;
            pre = num;
        }
        return size;
		 */
	}
}
