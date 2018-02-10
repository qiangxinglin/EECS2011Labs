package A1Q3S;

import java.util.*;

/**
 * Tests class MinStack
 * @author jameselder
 */
public class testMinStack {

    public static void main(String[] args) {
        MinStack<Integer> myMinStack = new MinStack<>();

        myMinStack.push(5); // 5
        myMinStack.push(3); // 3 5
        myMinStack.push(17);// 17 3 5
        myMinStack.push(13);// 13 17 3 5
        myMinStack.push(2);//  2 13 17 3 5
        myMinStack.push(11);// 11 2 13 17 3 5
        // test case 4//
        System.out.println("The minimum value currently on the stack is " + myMinStack.min()); // should be 2
        myMinStack.pop(); //  2 13 17 3 5
        myMinStack.pop(); // 13 17 3 5
        myMinStack.pop(); // 17 3 5
        // test case 4//
        System.out.println("The minimum value currently on the stack is " + myMinStack.min()); // should be 3

        myMinStack.pop(); //  3 5
        myMinStack.pop(); //  5
        // test case 4//
        System.out.println("The minimum value currently on the stack is " + myMinStack.min()); // should be 5
        myMinStack.pop(); // null

        // test case 4//
        try {
            myMinStack.min(); //should throw exception
        } catch (EmptyStackException esx) {
            System.out.println("Empty Stack Exception");
        }

        // test case 5//
        try {
            myMinStack.pop(); //should throw exception
        } catch (EmptyStackException esx) {
            System.out.println("Empty Stack Exception");
        }

    }
}
