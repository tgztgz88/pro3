package com.tgz;

public class singleton_innerTest {
    public static void main(String[] args) {
        singleton_inner instance1=singleton_inner.getinstance();
        singleton_inner instance2=singleton_inner.getinstance();
        System.out.println(instance1==instance2);

        new Thread(()->{
            singleton_inner instance3=singleton_inner.getinstance();
            System.out.println(instance3);
        }).start();
        new Thread(()->{
            singleton_inner instance3=singleton_inner.getinstance();
            System.out.println(instance3);
        }).start();
    }
}




    class singleton_inner{

       private static class  innerclass_holder{
           private static singleton_inner instance=new singleton_inner();
       };

        private singleton_inner(){

        }
        public static singleton_inner getinstance(){
            return innerclass_holder.instance;
        }
   }

