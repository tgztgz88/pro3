package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ThreeNumSum {
    public List<List<Integer>> threeSum(int[] nums) {
           List<List<Integer>> result=new ArrayList<List<Integer>>();
           int sum=0;
           boolean flag=false;
           for(int i=0;i<nums.length;i++){
               List<Integer> subList=new ArrayList<Integer>();
               subList.add(nums[i]);
               sum=nums[i];
               for(int j=0;j<nums.length;j++) {
                   if(subList.size()==3){
                       subList.remove(2);
                       subList.remove(1);
                       subList.remove(0);
                       sum=nums[i];
                       subList.add(nums[i]);
                   };
                   if (i == j) {continue; } //
                   subList.add(nums[j]);
                   sum+=nums[j];
                   for(int k=0;k<nums.length;k++) {
                       flag=false;
                       if(subList.size()==3){break;}
                       if (k == i) {continue; } //
                       if (k == j) {continue; } //
                       sum+=nums[k];
                       if(sum!=0){
                           sum=sum-nums[k];
                           continue;
                       }
                       if(sum==0){
                           subList.add(nums[k]);
                         Collections.sort(subList);
                         if (result.size()==0) {
                             List<Integer> subList1=new ArrayList<Integer>();
                             subList1.add(subList.get(0));
                             subList1.add(subList.get(1));
                             subList1.add(subList.get(2));
                             result.add(subList1);
                             break;}
                         for (int now=0;now<result.size();now++){
                             List<Integer> a=result.get(now);
                             if (a.get(0)==subList.get(0)&&a.get(1)==subList.get(1)&&a.get(2)==subList.get(2)){
                                 System.out.println("此3个数已经在结果里了 不放进去了");
                                 flag=true;
                                 break;
                           }
                          }if (flag==false){List<Integer> subList1=new ArrayList<Integer>();
                           subList1.add(subList.get(0));
                           subList1.add(subList.get(1));
                           subList1.add(subList.get(2));
                           result.add(subList1);
                           break;}
                        }
                   }
               }
           }

           return result;
    }

    public static void main(String[] args) {
        ThreeNumSum threeNumSum=new ThreeNumSum();
        int [] ss={-1, 0, 1, 2, -1, -4};
       List<List<Integer>> result=threeNumSum.threeSum(ss);
        System.out.println(result.size());
       for (List<Integer> a:result){
           System.out.println(a);
       }
    }

}
