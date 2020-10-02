package com.tgz;

import java.util.ArrayList;

public class ObserverTest {
    public static void main(String[] args) {
        WeatherData weatherData=new WeatherData();
        Baidu baidu=new Baidu();
        Sina sina=new Sina();
        Tengxun tengxun=new Tengxun();
        weatherData.registerObserver(baidu);
        weatherData.registerObserver(sina);
        weatherData.registerObserver(tengxun);
        weatherData.setAll(37f,112f,1.45f);
    }
}

interface Subject{
   void registerObserver(Observer addobject);
   void remove(Observer revobject);
   void notifyObserver(ArrayList<Observer> objects);
}

interface Observer{
    void updata(float temperature,float pressure,float humidity);
}

class WeatherData implements Subject{
    private float temperature;
    private float pressure;
    private float humidity;
    ArrayList<Observer> observers;

   public  WeatherData(){
        this.observers=new ArrayList<Observer>();
        System.out.println("客户名单已建立");
    }


    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setAll(float temperature,float pressure,float humidity){
        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        //更新完实时数据要立即通知各个对接公司
        notifyObserver(this.observers);
    }

    @Override
    public void registerObserver(Observer addobject) {
         observers.add(addobject);
    }

    @Override
    public void remove(Observer revobject) {
         observers.remove(revobject);
    }

    @Override
    public void notifyObserver(ArrayList<Observer> objects) {
         for(Observer o:objects){
             o.updata(this.temperature,this.pressure,this.humidity);
         }
    }
}



class Baidu implements Observer{
    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void updata(float temperature, float pressure, float humidity) {
        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        System.out.println("百度公司：\n"+
                "温度得到更新:"+ this.temperature+"湿度得到更新:"+ this.pressure+"气压得到更新:"+this.humidity);
    }
}


class Tengxun implements Observer{
    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void updata(float temperature, float pressure, float humidity) {
        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        System.out.println("腾讯公司：\n"+
                "温度得到更新:"+ this.temperature+"湿度得到更新:"+ this.pressure+"气压得到更新:"+this.humidity);
    }
}

class Sina implements Observer{
    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void updata(float temperature, float pressure, float humidity) {
        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        System.out.println("新浪公司：\n"+
                "温度得到更新:"+ this.temperature+"湿度得到更新:"+ this.pressure+"气压得到更新:"+this.humidity);
    }
}