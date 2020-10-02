package com.tgz;

import java.util.Arrays;

import static jdk.nashorn.internal.objects.Global.print;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len=nums.length;

        for(int i=0;i<len;i++){
            if (nums[i]==val){
                System.arraycopy(nums,i+1,nums,i,nums.length-i-1);
                len--;
                i--;
            }
        }
        return len;
    }


    public static void main(String[] args) {
        RemoveElement removeElement=new RemoveElement();
        int[]ss={3,2,2,3};
        int len=removeElement.removeElement(ss,3);
        System.out.println("数组长度是："+len);
        for (int i = 0; i < len; i++) {
            System.out.println(ss[i]);
        }
        int[]ss1={0,1,2,3,4,5,6,7,8};
        //删除4号元素
        System.arraycopy(ss1,5,ss1,4,4);
        for (int i:ss){
            System.out.print(i+",");
        }

    }
}
