package com.spark.custompatterns.utils;

import org.apache.spark.api.java.function.Function;

public interface IExceptionDecoratorSpark {
	 static <Input, Output> Function<Input, Output> process(Function<Input, Output> fun, Output def) {
	        return new Function<Input, Output>() {
	            @Override
	            public Output call(Input o) {
	                try {
	                    return (Output) fun.call(o);
	                } catch (NullPointerException e) {
	                    return null;
	                } catch (Exception e) {
	                    return def;
	                }
	            }
	        };
	    }
}
