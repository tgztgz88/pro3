package com.tgz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApproximateValue {
    public List<Integer> selectApproximateValue(int[] arrayList,int[] selectarrays){
         List<Integer> result=new ArrayList<>();
         int diffrent;
         int now;

         for (int i=0;i<selectarrays.length;i++){
             now=selectarrays[i];
             int temp=0;
             int min=99999999;
             for(int j=0;j<arrayList.length;j++){
             diffrent=Math.abs(now-arrayList[j]);
             if(diffrent<min){
                 min=diffrent;
                 temp=j;
             }
           }
             result.add(arrayList[temp]);

             /*for (int k=0;k<sublist.size();k++){
            if(sublist.get(k)<=min){
                if(sublist.get(k)<sublist.get(temp))
                {min=sublist.get(k);
                temp=k;}
            }
          }*/

         }

         return result;
    }

    public static void main(String[] args) {
        ApproximateValue approximateValue=new ApproximateValue();
        int[] arrayList={1,2,3,4,5};
        int[] selectarrays={3,0,7,2,5};
        List<Integer> result=approximateValue.selectApproximateValue(arrayList,selectarrays);
        for(int i:result){
            System.out.println(i);
        }
    }
}
