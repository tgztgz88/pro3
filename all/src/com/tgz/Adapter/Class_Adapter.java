package com.tgz.Adapter;
import com.tgz.Adapter.Phone;

public class Class_Adapter {
    public static void main(String[] args) {
        Phone phone=new Phone();
        phone.Charging(new VoltageAdapter());
    }
}


class Voltage220{
    public int OutputVoltage220V(){
        int src=220;
        return src;
    }
}

interface Voltage5{
    public int  OutputVoltage5V();
}

class VoltageAdapter extends Voltage220 implements Voltage5{

    @Override
    public int OutputVoltage5V() {
        int src=OutputVoltage220V();
        int dstV=src/44;
        return dstV;
    }
}


