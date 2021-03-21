package com.yxxx.javasec.deserialize;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;

public class MyObjectInputStream extends ObjectInputStream {
    private static ArrayList<String> blackList = new ArrayList<>();

    static {
        blackList.add("org.apache.commons.collections.functors");
        blackList.add("java.rmi.server");
    }

    public MyObjectInputStream(InputStream inputStream)throws Exception{
        super(inputStream);
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
        for (String s : blackList) {
            if (desc.getName().contains(s)){
                throw new ClassNotFoundException("go out!");
            }
        }
        return super.resolveClass(desc);
    }

    @Override
    protected Class<?> resolveProxyClass(String[] interfaces) throws IOException, ClassNotFoundException {
        return super.resolveProxyClass(interfaces);
    }
}
