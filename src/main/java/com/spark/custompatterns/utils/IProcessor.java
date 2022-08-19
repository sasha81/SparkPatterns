package com.spark.custompatterns.utils;


import java.util.function.Function;

public interface IProcessor<Input, Output> {
    static <Input, Output> Function<Input, Output> process(Function<Input, Output> fun, Output def) {
        return new Function<Input, Output>() {
            @Override
            public Output apply(Input o) {
                try {
                    return (Output) fun.apply(o);
                } catch (NullPointerException e) {
                    return null;
                } catch (Exception e) {
                    return def;
                }
            }
        };
    }
}

