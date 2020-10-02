package com.tgz;

import java.util.HashMap;

public class FlyWeightTest {
    public static void main(String[] args) {
        WebSiteFactory webSiteFactory=new WebSiteFactory();
        ConcreteFlyWeight web1=webSiteFactory.GetFlyWeight("微博");
        web1.use();
        ConcreteFlyWeight web2=webSiteFactory.GetFlyWeight("微博");
        web2.use();
        ConcreteFlyWeight web3=webSiteFactory.GetFlyWeight("微博");
        web3.use();
        ConcreteFlyWeight web4=webSiteFactory.GetFlyWeight("微博");
        web4.use();
        ConcreteFlyWeight web5=webSiteFactory.GetFlyWeight("博客");
        web5.use();

        System.out.println(webSiteFactory.getALLNum());
     }
}

 abstract class WebSite{
    public abstract void use();
 }


 class ConcreteFlyWeight extends WebSite{
    private String type;

     public ConcreteFlyWeight(String type) {
         this.type = type;
     }

     @Override
     public void use() {
         System.out.println("新闻发布的形式为"+this.type);
     }
 }


 class WebSiteFactory{
    private HashMap<String,ConcreteFlyWeight> pool=new HashMap<>();  //池

    public ConcreteFlyWeight GetFlyWeight(String key){
        if (!pool.containsKey(key)){
            pool.put(key,new ConcreteFlyWeight(key));
        }
        return pool.get(key);
    }

    public int getALLNum(){
        return pool.size();
    }
 }