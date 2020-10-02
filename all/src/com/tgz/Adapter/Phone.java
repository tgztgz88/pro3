package com.tgz.Adapter;

public class Phone {   //充电类 客户端最终只调用这个类
    public void  Charging(Voltage5 voltage5){
        if(voltage5.OutputVoltage5V()==5){
            System.out.println("充电成功");
        }else {
            System.out.println("电压不匹配  不能充电");
        }
    }
}
