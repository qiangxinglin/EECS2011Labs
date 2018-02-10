package A1Q1S;

/**
 *
 * @author jameselder
 */
public class gradeSparseNumericVector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SparseNumericVector X = new SparseNumericVector();
        SparseNumericVector Y = new SparseNumericVector();
        double projection = 0;
        long startTime = System.nanoTime();
        
        int[] marks = new int[5];
        int nCorrect = 0;
        
        X.add(new SparseNumericElement(150000, 3.1415));
        X.add(new SparseNumericElement(15, 3));
        X.add(new SparseNumericElement(1500, 3.14));
        X.add(new SparseNumericElement(150, 3.1));
        X.add(new SparseNumericElement(15000, 3.141));
        Y.add(new SparseNumericElement(150000, 1));
        Y.add(new SparseNumericElement(15, 1));
        X.remove((long) 150);

        //Test case 1
        System.out.print("Test Case 1");
        try {
            projection = X.dot(Y);
            if (projection == 3 * 1 + 3.1415 * 1) { //answer should be 6.1415
                System.out.println("Correct");
                marks[1] = 1;
            } else {
                System.out.println("Incorrect");
            }
        } catch (Exception ex) {
            System.out.println("Incorrect: dot threw an exception");
        }
        System.out.println("The inner product of");
        System.out.print(X);
        System.out.println("and");
        System.out.print(Y);
        System.out.println("is ");
        System.out.printf("%.5f\n\n",projection); //answer should be 3*1 + 3.1415*1 = 6.1415

        X.add(new SparseNumericElement(1, 1));
        Y.add(new SparseNumericElement(1, 1));
       //Test case 2
        System.out.print("Test Case 2");
        try {
            projection = X.dot(Y);
            if (projection == 1 * 1 + 3 * 1 + 3.1415 * 1) { //answer should be 7.1415
                System.out.println("Correct");
                marks[2] = 1;
            } else {
                System.out.println("Incorrect");
            }
        } catch (Exception ex) {
            System.out.println("Incorrect: dot threw an exception");
        }
        System.out.println("The inner product of");
        System.out.print(X);
        System.out.println("and");
        System.out.print(Y);
        System.out.println("is ");
        System.out.printf("%.5f\n\n",projection); //answer should be 1*1 + 3*1 + 3.1415*1 = 7.1415

        X.add(new SparseNumericElement(Long.MAX_VALUE, 2));
        Y.add(new SparseNumericElement(Long.MAX_VALUE, -2));
        //Test case 3
        System.out.print("Test Case 3");
        try {
            projection = X.dot(Y);
            if (projection == 1 * 1 + 3 * 1 + 3.1415 * 1 + 2 * -2) { //answer should be 3.1415
                System.out.println("Correct");
                marks[3] = 1;
            } else {
                System.out.println("Incorrect");
            }
        } catch (Exception ex) {
            System.out.println("Incorrect: dot threw an exception");
        }
        System.out.println("The inner product of");
        System.out.print(X);
        System.out.println("and");
        System.out.print(Y);
        System.out.println("is ");
        System.out.printf("%.5f\n\n",projection); //answer should be 1*1 + 3*1 + 3.1415*1 + 2 * -2 = 3.1415

        Y.remove((long) 150000);
       //Test case 4
        System.out.print("Test Case 4");
        try {
            projection = X.dot(Y);
            if (projection == 1 * 1 + 3 * 1 + 2 * -2) { //answer should be 0
                System.out.println("Correct");
                marks[4] = 1;
            } else {
                System.out.println("Incorrect");
            }
        } catch (Exception ex) {
            System.out.println("Incorrect: dot threw an exception");
        }
        System.out.println("The inner product of");
        System.out.print(X);
        System.out.println("and");
        System.out.print(Y);
        System.out.println("is ");
        System.out.printf("%.5f\n\n",projection); //answer should be 1*1 + 3*1  + 2 * -2 = 0

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
