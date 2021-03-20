package com.yxxx.javasec.deserialize;

import java.io.ObjectInputStream;
import java.io.Serializable;

public class Calc implements Serializable {
    private boolean canPopCalc;

    public Calc(){
        canPopCalc = false;
    }

    private void readObject(ObjectInputStream objectInputStream) throws Exception{
        objectInputStream.defaultReadObject();
        if (this.canPopCalc){
            Runtime.getRuntime().exec("touch /tmp/lab1_"+System.currentTimeMillis());
        }
    }
}
