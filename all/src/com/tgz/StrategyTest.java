package com.tgz;

public class StrategyTest {
    public static void main(String[] args) {
        Plane plane1=new FightPlane();
        Plane plane2=new PersonalPlane();
        System.out.println(plane1);
    }
}

interface FlyStrategy{
    void fly();
}

class FlyStraightLine implements FlyStrategy{
    @Override
    public void fly() {
        System.out.println("直线飞行");
    }
}

class FlyCurvilinear implements FlyStrategy{
    @Override
    public void fly() {
        System.out.println("曲线飞行");
    }
}

class FlyNO implements FlyStrategy{
    @Override
    public void fly() {
        System.out.println("不飞行");
    }
}

interface SpeedStrategy{
    void speed();
}

class HighSpeed implements SpeedStrategy{
    @Override
    public void speed() {
        System.out.println("高速");
    }
}

class MiddleSpeed implements SpeedStrategy{
    @Override
    public void speed() {
        System.out.println("中速");
    }
}

class SlowSpeed implements SpeedStrategy{
    @Override
    public void speed() {
        System.out.println("慢速");
    }
}

abstract class Plane{
    private FlyStrategy flyStrategy;
    private SpeedStrategy speedStrategy;


    public void setFlyStrategy(FlyStrategy flyStrategy) {
        this.flyStrategy = flyStrategy;
    }

    private void fly(){
        if(flyStrategy!=null)
        flyStrategy.fly();
        else System.out.println("此飞机还没有设置飞行策略");
    }

    public void setSpeedStrategy(SpeedStrategy speedStrategy) {
        this.speedStrategy = speedStrategy;
    }

    private void speed(){
        if(speedStrategy!=null)
        speedStrategy.speed();
        else System.out.println("此飞机还没有设置速度策略");
    }

    @Override
    public String toString() {
        System.out.println("此飞机的飞行策略");
        flyStrategy.fly();
        System.out.println("此飞机的速度策略");
        speedStrategy.speed();
        return "";
    }
}

class FightPlane extends Plane{
   public FightPlane(){
       this.setFlyStrategy(new FlyCurvilinear());
       this.setSpeedStrategy(new HighSpeed());
   }
}

class PersonalPlane extends Plane{
    public PersonalPlane(){
        this.setFlyStrategy(new FlyStraightLine());
        this.setSpeedStrategy(new SlowSpeed());
    }
}