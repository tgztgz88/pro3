package com.tgz;

import java.util.Arrays;

public class TwoNumSum {
    public int[] twoSum(int[] nums, int target) {
        int result[]=new int[2];
        for (int i=0;i<nums.length;i++){
         int will=target-nums[i];
          for (int j=i+1;j<nums.length;j++){
              if(will==nums[j]){
                  result[0]=i;
                  result[1]=j;
                  return result;
              }
          }
        }return result;
    }

    public static void main(String[] args) {
        TwoNumSum twoNumSum=new TwoNumSum();
       int[] result=twoNumSum.twoSum(new int[] {3,4,2},6);
        System.out.println(result[0]+"----"+result[1]);
    }
}
