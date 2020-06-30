package com.example.day628.factory;

public class BananaFactory extends Factory {
    @Override
    public Product createProduct() {
        return new Banana();
    }
}
