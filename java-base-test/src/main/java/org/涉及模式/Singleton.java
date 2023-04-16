package org.涉及模式;


import javax.lang.model.element.VariableElement;

public class Singleton {

    // 饿汉式
    private static Singleton singleton = new Singleton();
    private Singleton(){}
    // 只提供一个访问点
    public static Singleton getSingleton(){
        return singleton;
    }

}

// 懒汉
class Singleton2 {
    private Singleton2(){}
    private static Singleton2  singleton2 ;
    public static synchronized Singleton2 getSingleton2(){
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}

class Singleton3{
    private Singleton3(){}
    // volatile 被线程可读
    private static volatile Singleton3 singleton3;

    public static Singleton3 getSingleton3(){
        if (singleton3 == null) {
            synchronized (Singleton3.class){
                if (singleton3 == null) {
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }


}
