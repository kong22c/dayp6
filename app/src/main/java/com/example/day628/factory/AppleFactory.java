package com.example.day628.factory;

public class AppleFactory extends Factory {
    @Override
    public Product createProduct() {
        return new Apple();
    }
}
