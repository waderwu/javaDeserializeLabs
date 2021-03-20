package com.yxxx.javasec.deserialize;

import org.apache.commons.collections.Transformer;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.net.URL;
import java.net.URLClassLoader;

public class MyObjectInputStream extends ObjectInputStream {
    private ClassLoader classLoader;
    public MyObjectInputStream(InputStream inputStream)throws Exception{
        super(inputStream);
        URL[] urls = ((URLClassLoader)Transformer.class.getClassLoader()).getURLs();
        classLoader = new URLClassLoader(urls);
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
        Class clazz = classLoader.loadClass(desc.getName());
        return clazz;
    }
}
