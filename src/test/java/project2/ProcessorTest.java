package project2;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;

import org.junit.jupiter.api.Test;

import com.spark.custompatterns.utils.IProcessor;

public class ProcessorTest {

    @Test
    public void basicProcessorTest() {
        Double def = 10000.0;
        Double shouldBe = 0.5;
        Function<Integer, Double> fun = (x) -> 1.0 / x;
        Function<Integer, Double> outFun = IProcessor.process(fun, def);
        Double result = outFun.apply(2);
        assertEquals(result, shouldBe);

    }

    @Test
    public void exceptionProcessorTest() {
        Integer def = 10;
        Double shouldBe = 0.5;
        Integer[] input = new Integer[0];

        Function<Integer[], Integer> fun = (x) -> x[1];
        Function<Integer[], Integer> outFun = IProcessor.process(fun, def);
        Integer result = outFun.apply(input);
        assertEquals(result, def);

    }
}