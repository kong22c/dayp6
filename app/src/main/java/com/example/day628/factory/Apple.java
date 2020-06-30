package com.example.day628.factory;

import android.util.Log;

public class Apple extends Product {
    @Override
    public void print() {
        Log.d("apple", "print: this is apple ");
    }
}
