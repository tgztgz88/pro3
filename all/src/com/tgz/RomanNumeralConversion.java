package com.tgz;

import com.sun.org.apache.bcel.internal.generic.SWITCH;

public class RomanNumeralConversion {
    public static void main(String[] args) {
        String ss="III";
        RomanNumeralConversion romanNumeralConversion=new RomanNumeralConversion();
        System.out.println( romanNumeralConversion.romanToInt(ss));
    }



    public int romanToInt(String s) {
        int sum=0;
        char now;
        char charnext;
        for(int i=0;i<s.length();i++){
           now= s.charAt(i);
            switch (now){
                case 'I':
                    sum=sum+1;
                    if(i<s.length()-1){
                    charnext=s.charAt(i+1);
                    if(charnext=='V'){
                        i++;
                        sum=sum+3;
                        break;
                    }
                    else if (charnext=='X'){
                        i++;
                        sum=sum+8;
                        break;}
                    }break;
                case 'V':sum=sum+5;break;
                case 'X':
                    sum=sum+10;
                    if(i<s.length()-1){
                    charnext=s.charAt(i+1);
                    if(charnext=='L'){
                        i++;
                        sum=sum+30;
                        break;
                    }
                    else if (charnext=='C'){
                        i++;
                        sum=sum+80;
                        break;}
                    }break;
                case 'L':sum=sum+50;break;
                case 'C':
                    sum=sum+100;
                    if(i<s.length()-1){
                    charnext=s.charAt(i+1);
                    if(charnext=='D'){
                        i++;
                        sum=sum+300;
                        break;
                    }
                    else if (charnext=='M'){
                        i++;
                        sum=sum+800;
                        break;
                    }
                    }break;
                case 'D':sum=sum+500;break;
                case 'M':sum=sum+1000;break;
            }
        }
        return sum;
    }


}
