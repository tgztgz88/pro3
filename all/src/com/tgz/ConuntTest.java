package com.tgz;

public class ConuntTest {
    public static void main(String[] args) {
        final Conunter conunter=new Conunter();
        for (int i=0;i<1000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    conunter.inc();
                }
            }).start();
        }
        System.out.println(conunter);
    }

}
