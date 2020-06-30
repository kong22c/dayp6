package com.example.day628.single;

public class SingleTon1 {
    private static SingleTon1 singleTon1=null;
    private SingleTon1(){}
    public static  SingleTon1 getInstance(){
        if (singleTon1==null){
            singleTon1=new SingleTon1();
        }
        return singleTon1;
    }
}
