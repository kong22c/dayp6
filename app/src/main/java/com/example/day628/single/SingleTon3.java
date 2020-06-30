package com.example.day628.single;

public class SingleTon3 {
    private SingleTon3(){}
    public static  SingleTon3 getInstance(){
return Holder.singleTon3;
    }
    private static class Holder{
        private static SingleTon3 singleTon3=new SingleTon3();
    }
}
