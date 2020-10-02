package com.tgz;

import java.io.Serializable;

public class Prototype {
    public static void main(String[] args) throws Exception {
        Sheep tom=new Sheep("tom","female",10,"white");
        DeepSheep deepsheepprototype=new DeepSheep("doli","female",10,"white",tom);
        DeepSheep sheep1=(DeepSheep) deepsheepprototype.clone();
        System.out.println(deepsheepprototype+""+deepsheepprototype.getFriend().hashCode());
        System.out.println(sheep1+""+sheep1.getFriend().hashCode());
    }
}


class Sheep implements Cloneable, Serializable {
    private String name;
    private String gander;
    private int age;
    private String color;

    public Sheep() {
    }

    public Sheep(String name, String gander, int age, String color) {
        this.name = name;
        this.gander = gander;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", gander='" + gander + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGander() {
        return gander;
    }

    public void setGander(String gander) {
        this.gander = gander;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

            Sheep sheep=new Sheep();

        return super.clone();
    }
}


class DeepSheep implements Cloneable,Serializable{
    private String name;
    private String gander;
    private int age;
    private String color;
    private Sheep friend;

    public DeepSheep() {
        super();
    }

    public DeepSheep(String name, String gander, int age, String color, Sheep friend) {
        this.name = name;
        this.gander = gander;
        this.age = age;
        this.color = color;
        this.friend = friend;
    }

    @Override
    public String toString() {
        return "DeepSheep{" +
                "name='" + name + '\'' +
                ", gander='" + gander + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", friend=" + friend +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGander() {
        return gander;
    }

    public void setGander(String gander) {
        this.gander = gander;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Sheep getFriend() {
        return friend;
    }

    public void setFriend(Sheep friend) {
        this.friend = friend;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep=null;
        deep=super.clone();  //完成基本数据类型+字符串的拷贝
        DeepSheep deepSheep=(DeepSheep)deep;
       /* deepSheep.friend=(Sheep)friend.clone();*/
        deepSheep.setFriend((Sheep) friend.clone());
        return deepSheep;
    }
}
