package com.yxxx.javasec.deserialize;

import java.io.ObjectInputStream;
import java.io.Serializable;

public class Calc implements Serializable {
    private boolean canPopCalc;
    private String cmd;

    public Calc(){
        canPopCalc = false;
        cmd = "ls -al";
    }

    private void readObject(ObjectInputStream objectInputStream) throws Exception{
        objectInputStream.defaultReadObject();
        if (this.canPopCalc){
            Runtime.getRuntime().exec(this.cmd);
        }
    }
}
