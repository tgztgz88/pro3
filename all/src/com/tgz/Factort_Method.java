package com.tgz;

public class Factort_Method {
    public static void main(String[] args) {
         Application application=new Application();
        Product productA= application.getObject("1");
        Product productB=application.getObject("2");
        productA.method1();
        productB.method1();
    }
}

interface Product{
    public void method1();
}

class ProductFactory{
       public static Product createProduct(String type){
           if(type.equals("1")){
               return new ProductA();
           }else if(type.equals("2")){
               return new ProductB();
           }else
           return null;
       }
}

class ProductA implements Product{
    public void method1(){
        System.out.println("ProductA.method1 is executed...");
    }
}

class ProductB implements Product{
    public void method1(){
        System.out.println("ProductB.method1 is executed...");
    }
}

class Application{
    private Product createProduct(String type){
        //....init
        //....
        return  ProductFactory.createProduct(type);
    }

    public Product getObject(String type){
        Product product=createProduct(type);
        //,,,
        return product;
    }
}