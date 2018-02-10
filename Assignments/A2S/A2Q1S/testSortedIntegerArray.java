package A2Q1S;
import java.util.*;

/**
 *
 * @author jameselder
 */
public class testSortedIntegerArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] myIntegerArray = new int[10];

        SortedIntegerArray mySortedIntegerArray;
        int[] ks = {2, 3, 1, 20, -3, 59};
 
        // Non-random test input
        int[][] myIntegerArrays = new int[6][];

        myIntegerArrays[0] = new int[0];

        myIntegerArrays[1] = new int[1];
        myIntegerArrays[1][0] = 1;

        myIntegerArrays[2] = new int[2];
        myIntegerArrays[2][0] = 1;
        myIntegerArrays[2][1] = 2;

        myIntegerArrays[3] = new int[2];
        myIntegerArrays[3][0] = 10;
        myIntegerArrays[3][1] = 10;

        myIntegerArrays[4] = new int[3];
        myIntegerArrays[4][0] = 17;
        myIntegerArrays[4][1] = -20;
        myIntegerArrays[4][2] = 4;

        myIntegerArrays[5] = new int[7];
        myIntegerArrays[5][0] = 11;
        myIntegerArrays[5][1] = 51;
        myIntegerArrays[5][2] = 17;
        myIntegerArrays[5][3] = 33;
        myIntegerArrays[5][4] = 7;
        myIntegerArrays[5][5] = 23;
        myIntegerArrays[5][6] = 8;
 
        for (int i = 0; i < 6; i++) {
            mySortedIntegerArray = new SortedIntegerArray(myIntegerArrays[i]);
            if (mySortedIntegerArray.kPairSum(ks[i])) {
                System.out.println("The array " + Arrays.toString(myIntegerArrays[i]) + " contains two elements that sum to " + ks[i]);
            } else {
                System.out.println("The array " + Arrays.toString(myIntegerArrays[i]) + " does not contain two elements that sum to " + ks[i]);
            }
        }
    }
}
