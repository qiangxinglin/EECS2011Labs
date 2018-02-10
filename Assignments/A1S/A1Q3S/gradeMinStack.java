package A1Q3S;

import java.util.*;

/**
 * Tests class MinStack
 * @author jameselder
 */
public class gradeMinStack {

    public static void main(String[] args) {
        MinStack<Integer> myMinStack = new MinStack<>();
        int val;
        long startTime = System.nanoTime();        
        int[] marks = new int[12];
        int nCorrect = 0;

        myMinStack.push(5); // 5
        myMinStack.push(3); // 3 5
        myMinStack.push(17);// 17 3 5
        myMinStack.push(13);// 13 17 3 5
        myMinStack.push(2);//  2 13 17 3 5
        myMinStack.push(11);// 11 2 13 17 3 5
        
        //test case 1//
        System.out.println("Test case 1:");
        try {
            val = myMinStack.min();
            if (val == 2) { //answer should be 2
                System.out.println("Correct");
                marks[1] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println("The minimum value currently on the stack is " + val); // should be 2
        } catch (EmptyStackException esx) {
            System.out.println("Incorrect:  Empty stack exception.");
        }

        //test case 2//
        System.out.println("Test case 2:");
        try {
            val = myMinStack.pop(); // 11, leaving 2 13 17 3 5
            if (val == 11) { //answer should be 11
                System.out.println("Correct");
                marks[2] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println(val + " has been popped from the stack."); // should be 11
        } catch (EmptyStackException esx) {
            System.out.println("Incorrect:  Empty stack exception.");
        }

         //test case 3//
        System.out.println("Test case 3:");
        try {
            val = myMinStack.pop(); // 2, leaving 13 17 3 5
            if (val == 2) { //answer should be 2
                System.out.println("Correct");
                marks[3] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println(val + " has been popped from the stack."); // should be 2
        } catch (EmptyStackException esx) {
            System.out.println("Incorrect:  Empty stack exception.");
        }

         //test case 4//
        System.out.println("Test case 4:");
        try {
            val = myMinStack.pop(); // 13, leaving 17 3 5
            if (val == 13) { //answer should be 13
                System.out.println("Correct");
                marks[4] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println(val + " has been popped from the stack."); // should be 13
        } catch (EmptyStackException esx) {
            System.out.println("Incorrect:  Empty stack exception.");
        }

        // test case 5//
      System.out.println("Test case 5:");
        try {
            val = myMinStack.min();
            if (val == 3) { //answer should be 3
                System.out.println("Correct");
                marks[5] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println("The minimum value currently on the stack is " + val); // should be 3
        } catch (EmptyStackException esx) {
            System.out.println("Incorrect:  Empty stack exception.");
        }

          //test case 6//
        System.out.println("Test case 6:");
        try {
            val = myMinStack.pop(); // 17, leaving 3 5
            if (val == 17) { //answer should be 17
                System.out.println("Correct");
                marks[6] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println(val + " has been popped from the stack."); // should be 17
        } catch (EmptyStackException esx) {
            System.out.println("Incorrect:  Empty stack exception.");
        }

         //test case 7//
        System.out.println("Test case 7:");
        try {
            val = myMinStack.pop(); // 3, leaving 5
            if (val == 3) { //answer should be 3
                System.out.println("Correct");
                marks[7] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println(val + " has been popped from the stack."); // should be 3
        } catch (EmptyStackException esx) {
            System.out.println("Incorrect:  Empty stack exception.");
        }

        // test case 8//
      System.out.println("Test case 8:");
        try {
            val = myMinStack.min();
            if (val == 5) { //answer should be 5
                System.out.println("Correct");
                marks[8] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println("The minimum value currently on the stack is " + val); // should be 5
        } catch (EmptyStackException esx) {
            System.out.println("Incorrect:  Empty stack exception.");
        }

         //test case 9//
        System.out.println("Test case 9:");
        try {
            val = myMinStack.pop(); // 5, leaving null
            if (val == 5) { //answer should be 5
                System.out.println("Correct");
                marks[9] = 1;
            } else {
                System.out.println("Incorrect");
            }
            System.out.println(val + " has been popped from the stack."); // should be 5
        } catch (EmptyStackException esx) {
            System.out.println("Incorrect:  Empty stack exception.");
        }


        // test case 10//
        System.out.println("Test case 10:");
        try {
            myMinStack.min(); //should throw exception
            System.out.println("Incorrect:  should throw empty stack exception.");
        } catch (EmptyStackException esx) {
            System.out.println("Correct:  Empty Stack Exception");
            marks[10] = 1;
        }

        // test case 11//
        System.out.println("Test case 11:");
        try {
            myMinStack.pop(); //should throw exception
            System.out.println("Incorrect:  should throw empty stack exception.");
        } catch (EmptyStackException esx) {
            System.out.println("Correct:  Empty Stack Exception");
            marks[11] = 1;
        }
        long stopTime = System.nanoTime();
        double elapsedTime = (double) (stopTime - startTime) / 1000000; //in msec
        System.out.println("Execution Time (msec): " + elapsedTime);

        System.out.print("Test Case Summary: ");
        for (int i = 1; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
            nCorrect += marks[i];
        }
        System.out.println();
        System.out.println("Test Case Grade: " + (double) nCorrect / (marks.length - 1));


    }
}
