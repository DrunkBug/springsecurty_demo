package org.spring.demo.springsecurity.entity;

import java.util.Arrays;


public class Demo {
	public static void main(String[] args) throws CloneNotSupportedException {
		User user1 = new User();
		user1.setUserName("1");
		 User user2 =(User)user1.clone();
		user1.setUserName("2");
//		int[] nums = new int[]{1,2,2,4,2};
//    	Arrays.sort(nums);
//    	for(int i :nums) {
//
//    		System.out.println(i);
//    	}
//		canConstruct("a","b");

//		 int[] a = {1,3,2};
//		 int b=5;
//		 numSubarrayProductLessThanK(a,b);
	}
    public static boolean canConstruct(String ransomNote, String magazine) {

    	if(ransomNote.length()>magazine.length()) {
    		return false;
    	}

    	int[] arr = new int[26];

    	for(char m : magazine.toCharArray()) {
    		arr[m-'a'] ++;
    	}

    	for(char r : ransomNote.toCharArray()) {
    		 if(--arr[r-'a']<0) {
    			 return false;
    		 }
    	}
    	return true;
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<1) return 0;
    	int sum=1;
    	int count =0;
    	int j=0;
    	for(int i=0;i<nums.length;i++) {
    		sum = sum*nums[i];
    		while(sum>=k) {
    			sum/=nums[j];
    			j++;
    		}
    		count+=i-j+1;
    	}
    	return count;
    }

}

