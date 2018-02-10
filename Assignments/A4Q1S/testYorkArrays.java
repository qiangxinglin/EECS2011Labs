package A4Q1S;
import java.util.*;
import java.lang.Math.*;

/**
 *
 * @author jameselder
 */
public class testYorkArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[] a = {64, -3, 29, 843, -11, 47, 47, 20, 65, 39, 1, 3, 945, 4, 367};
        Integer[] b = null;
        long startTime, endTime;
        
        try {
            YorkArrays.mergeSort(b);
        } catch (NullPointerException x) {
            System.out.println("mergeSort correctly detects null pointer");
        }
        try {
            YorkArrays.heapSort(b);
        } catch (NullPointerException x) {
            System.out.println("heapSort correctly detects null pointer");
        }
        
        System.out.println("Input Array: " + Arrays.toString(a));
        
        try {
            startTime = System.nanoTime();
            b = YorkArrays.mergeSort(a);
            endTime = System.nanoTime();
            System.out.println("Output Array (MergeSort)," + (endTime - startTime) / 1000 + " microseconds: " + Arrays.toString(b));

        } catch (Exception x) {
            System.out.println("Test Case 1 Fails");
        }

        b = a.clone();
        try {
            startTime = System.nanoTime();
            YorkArrays.heapSort(a);
            endTime = System.nanoTime();
            System.out.println("Output Array (HeapSort)," + (endTime - startTime) / 1000 + " microseconds: " + Arrays.toString(a));

        } catch (Exception x) {
            System.out.println("Test Case 2 Fails");
        }

       try {
            startTime = System.nanoTime();
            Arrays.sort(b);
            endTime = System.nanoTime();
            System.out.println("Output Array (QuickSort)," + (endTime - startTime) / 1000 + " microseconds: " + Arrays.toString(b));

        } catch (Exception x) {
            System.out.println("Test Case 3 Fails");
        }
    }
}
