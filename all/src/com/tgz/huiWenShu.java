package com.tgz;

public class huiWenShu {

        public boolean isPalindrome(int x) {
            String ss=String.valueOf(x);
            int j=ss.length()-1;
            for(int i=0;i<ss.length()/2;i++){
                if(ss.charAt(i)!=ss.charAt(j))
                {return false;
                }
                j--;
            }
            return true;
        }
    }

