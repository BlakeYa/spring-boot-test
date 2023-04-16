package com.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Subject {
    void request();
}

class RealSubject implements Subject {
    public void request() {
        System.out.println("RealSubject is handling the request.");
    }
}

class DynamicSubject implements InvocationHandler {
    private Object obj;

    public DynamicSubject(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before handling the request.");
        method.invoke(obj, args);
        System.out.println("After handling the request.");
        return null;
    }
}

public class DynamicClassMain {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        InvocationHandler handler = new DynamicSubject(realSubject);
        Class cls = realSubject.getClass();
        Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), handler);
        subject.request();
    }
}
