package com.yxxx.javasec.deserialize;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;

public class MyObjectInputStream extends ObjectInputStream {
    private static ArrayList<String> classBlackList = new ArrayList<>();
    private static ArrayList<String> proxyBlackList = new ArrayList<>();

    static {
        classBlackList.add("org.apache.commons.collections.functors");
        classBlackList.add("sun.rmi.server.UnicastRef");
        classBlackList.add("java.rmi.server.RemoteObjectInvocationHandler");
        proxyBlackList.add("java.rmi.registry");
    }

    public MyObjectInputStream(InputStream inputStream)throws Exception{
        super(inputStream);
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
        for (String s : classBlackList) {
            if (desc.getName().contains(s)){
                throw new ClassNotFoundException("go out!");
            }
        }
        return super.resolveClass(desc);
    }

    @Override
    protected Class<?> resolveProxyClass(String[] interfaces) throws IOException, ClassNotFoundException {
        for (String s : classBlackList) {
            for (String anInterface : interfaces) {
                if (anInterface.contains(s)){
                    throw new ClassNotFoundException("go out!");
                }
            }
        }
        return super.resolveProxyClass(interfaces);
    }
}
