package com.alan.demo.utils.lambda.myinterface;

@FunctionalInterface
public interface MyPredict<T> {

    public boolean test(T t);

}
