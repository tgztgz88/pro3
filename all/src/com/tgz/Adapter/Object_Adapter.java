package com.tgz.Adapter;

import java.util.ArrayList;

public class Object_Adapter {
    public static void main(String[] args) {
        Phone2 phone2=new Phone2();
        phone2.Charging(new VoltageAdapter02(new Voltage180()));
    }

}

class Voltage180{
    public int OutputVoltage180V(){
        int src=180;

        return src;
    }
}

interface Voltage18{
    public int  OutputVoltage18V();
}

class VoltageAdapter02 implements Voltage18{
    private Voltage180 voltage180;

    public VoltageAdapter02 (Voltage180 voltage180){
        this.voltage180=voltage180;

    }

    @Override
    public int OutputVoltage18V() {
        int src=voltage180.OutputVoltage180V();
        int dstV=src/10;
        return dstV;
    }
}

