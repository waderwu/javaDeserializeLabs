package com.yxxx.javasec.deserialize;

import java.io.*;

public class MarshalledObject implements Serializable {
    private byte[] bytes = null;

    public Object readResolve() throws Exception{
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object obj = objectInputStream.readObject();
        objectInputStream.close();
        return obj;
    }
}
