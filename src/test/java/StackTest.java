import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


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
    public void initToString() {
        stack = new Stack<>();
    }

    @Test
    public void testToString(){
        //arrange
        String result = "1->2->3";
        stack.push(3);
        stack.push(2);
        stack.push(1);

        //act
        String expended = stack.toString();

        //assert

        assertThat(expended, equalTo(result));
    }

    @BeforeEach
    public void initPush() {
        stack = new Stack<>();
    }

    @ParameterizedTest
    @MethodSource("pushParams")
    public void testPush(int a) {
        // arrange
        Node node = new Node(a);
        Stack<Integer> newStack = new Stack<>(node);

        // act
        stack.push(a);

        //assert
        assertThat(stack.toString(), equalTo(newStack.toString()));

    }

    @ParameterizedTest
    @MethodSource("popParams")
    public void testPop(Stack<Integer> stack, int result) {
        // act
        int expected = stack.pop();

        //assert
        assertThat(expected, is(equalTo(result)));
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

        //assert
        assertThat(expected,nullValue());
    }

    @Test
    public  void testReverse(){
        //arrange
        stack = new Stack<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);

        Stack<Integer> myStack = new Stack<>();
        myStack.push(2);
        myStack.push(1);
        myStack.push(0);

        //act
        Stack<Integer> resultStack = stack.reverse();

        //assert
        assertThat(resultStack.toString(), equalTo(myStack.toString()));
    }
}
