package com.tgz.Adapter;

public class Phone2 {   //充电类 客户端最终只调用这个类
    public void  Charging(Voltage18 voltage18){
        if(voltage18.OutputVoltage18V()==18){
            System.out.println("充电成功");
        }else {
            System.out.println("电压不匹配  不能充电");
        }
    }
}
