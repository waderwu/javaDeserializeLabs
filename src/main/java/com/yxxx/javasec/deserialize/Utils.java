package com.yxxx.javasec.deserialize;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Utils {
    public static String bytesTohexString(byte[] bytes){
        if (bytes == null) return null;
        StringBuilder ret = new StringBuilder(2*bytes.length);
        for (int i = 0 ; i < bytes.length ; i++) {
            int b;
            b = 0x0f & (bytes[i] >> 4);
            ret.append("0123456789abcdef".charAt(b));
            b = 0x0f & bytes[i];
            ret.append("0123456789abcdef".charAt(b));
        }
        return ret.toString();
    }

    public static String objectToHexString(Object obj)throws Exception{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        out = new ObjectOutputStream(bos);
        out.writeObject(obj);
        out.flush();
        byte[] bytes = bos.toByteArray();
        bos.close();
        String hex = bytesTohexString(bytes);
        return hex;
    }
}
