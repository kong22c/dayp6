package com.example.day628.single;

public class SingleTon2 {
    private static volatile SingleTon2 singleTon2=null;
    private SingleTon2(){}
    public static SingleTon2 getInstance(){
        if (singleTon2==null){
            synchronized (SingleTon2.class){
                if (singleTon2==null){
                    singleTon2=new SingleTon2();
                }
            }

        }
        return singleTon2;
    }
}
