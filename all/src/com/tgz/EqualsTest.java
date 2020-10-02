package com.tgz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EqualsTest {
    public static void main(String[] args) {
        HashMap<String,Integer> map1=new HashMap<>();
        map1.put("tgz",520);
        String ss=new String("tgz");
        int a=0;
        Lock lock=new ReentrantLock();

        System.out.println(a);
    }


}
