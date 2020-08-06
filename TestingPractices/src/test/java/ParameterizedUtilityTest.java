import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(Parameterized.class)
public class ParameterizedUtilityTest {

    private List<Integer> numbers;
    private int result;

    public ParameterizedUtilityTest(List<Integer> numbers, int result) {
        this.numbers = numbers;
        this.result = result;
    }


    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][]{
                {IntStream.range(1, 4).boxed().collect(Collectors.toList()), 6},
                {IntStream.range(2, 5).boxed().collect(Collectors.toList()), 9},
                {IntStream.range(-2, 3).boxed().collect(Collectors.toList()), 0},
        });
    }


    @Test
    public void shouldReturnSumOfPassedList() {
        Assert.assertEquals(result, new Utility().addList(numbers));
    }


}

