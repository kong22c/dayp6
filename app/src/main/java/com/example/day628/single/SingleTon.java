package com.example.day628.single;

public class SingleTon {
    private static SingleTon singleTon=new SingleTon();
    private SingleTon(){}
    public static SingleTon getInstance(){
        return singleTon;
    }
}
