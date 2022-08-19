package project2;

import static org.junit.Assert.assertEquals;

import org.apache.spark.api.java.function.Function;
import org.junit.jupiter.api.Test;

import com.spark.custompatterns.utils.IExceptionDecoratorSpark;

public class ProcessorSparkTest {
	@Test
    public void basicProcessorSparkTest() throws Exception {
        Double def = 10000.0;
        Double shouldBe = 0.5;
        Function<Integer, Double> fun = (x) -> 1.0 / x;
        Function<Integer, Double> outFun = IExceptionDecoratorSpark.process(fun, def);
        Double result = outFun.call(2);
        assertEquals(result, shouldBe);

    }

    @Test
    public void exceptionProcessorSparkTest() throws Exception {
        Integer def = 10;
        Double shouldBe = 0.5;
        Integer[] input = new Integer[0];

        Function<Integer[], Integer> fun = (x) -> x[1];
        Function<Integer[], Integer> outFun = IExceptionDecoratorSpark.process(fun, def);
        Integer result = outFun.call(input);
        assertEquals(result, def);

    }
}
