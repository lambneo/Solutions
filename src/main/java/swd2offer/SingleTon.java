package swd2offer;

/**
 * 单例写法 饿汉式，懒汉式（双重验证，静态内部类）
 */

//双重验证
public class SingleTon{
    private volatile static SingleTon instance = null;
    private SingleTon(){ }

    public static SingleTon getInstance(){
        if (instance == null){
            synchronized (SingleTon.class){
                if (instance == null)
                    instance = new SingleTon();
            }
        }
        return instance;
    }
}

//静态内部类
class SingleTon2 {
    private SingleTon2(){ }
    public static SingleTon2 getInstance(){
        return Inner.instance;
    }
    private static class Inner{
        private static final SingleTon2 instance = new SingleTon2();
    }
}

enum SingleTon3{
    INSTANCE;

    public static SingleTon3 getInstance(){
        return SingleTon3.INSTANCE;
    }
}

class SingleTonHungry{
    private static SingleTonHungry instance = new SingleTonHungry();
    private SingleTonHungry(){ }
    public static SingleTonHungry getInstance(){
        return instance;
    }
}
