import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class StackTest {
    static Stack<Integer> stack;

    public static Stream<Arguments> pushParams() {
        return Stream.of(
                Arguments.of(5),
                Arguments.of(0),
                Arguments.of(-1)
        );
    }

    public static Stream<Arguments> popParams() {
        Stack<Integer> stackTwo = new Stack<>();
        stackTwo.push(1);
        stackTwo.push(2);
        return Stream.of(
                Arguments.of(stackTwo, 2),
                Arguments.of(stackTwo, 1)
        );
    }

    @BeforeEach
    public void initPush() {
        stack = new Stack<>();
    }

    @ParameterizedTest
    @MethodSource("pushParams")
    public void testPush() {
        // arrange
        int a = 5;

        // act
        Executable executable = () -> stack.push(a);

        //asser
        Assertions.assertDoesNotThrow(executable);

    }

    @ParameterizedTest
    @MethodSource("popParams")
    public void testPop(Stack<Integer> stack, int result) {
        // act
        int expected = stack.pop();

        //asser
        Assertions.assertEquals(expected, result);
    }

    @BeforeEach
    public void initPopOnNull() {
        stack = new Stack<>();
        stack.push(0);
        stack.pop();
    }

    @Test
    public void testPopOnNull() {
        //act
        Integer expected = stack.pop();

        //asser
        Assertions.assertNull(expected);
    }
}
