package com.example.day628.factory;

import android.util.Log;

public class Banana extends Product {
    @Override
    public void print() {
        Log.d("banana", "print: 这是香蕉");
    }
}
