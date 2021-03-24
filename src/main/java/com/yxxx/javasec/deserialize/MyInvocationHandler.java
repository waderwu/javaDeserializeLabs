package com.yxxx.javasec.deserialize;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler, Serializable {
    private Class type;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method[] methods = this.type.getDeclaredMethods();
        for (Method xmethod : methods) {
            xmethod.invoke(args[0]);
        }
        return null;
    }
}
