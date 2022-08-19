package com.spark.custompatterns.utils;

public interface IChain {
    void setNextChain(IChain validator);

    boolean validate(String json);

}