package A4Q1S;
import java.util.*;

/**
 *
 * Provides two static methods for sorting Integer arrays (heapSort and mergeSort)
 * @author jameselder
 */
public class YorkArrays {

    /* Sorts the input array of Integers a using HeapSort.  Result is returned in a. 
       Makes use of java.util.PriorityQueue, which employs a min-heap:  
       smaller elements have highest priority  
       Sorting is NOT in place - heapSort allocates a separate heap-based priority queue. 
       Not a stable sort, in general.  
       Throws a null pointer exception if the input array is null.  */
    public static void heapSort(Integer[] a) throws NullPointerException {
        PriorityQueue minHeap = new PriorityQueue(Arrays.asList(a));
        for (int i = 0; i < a.length; i++) {
            a[i] = (Integer) minHeap.poll();
        }
    }
    
    /* Sorts the input array of Integers a using mergeSort and returns result.
     * Sorting is stable.
       Throws a null pointer exception if the input array is null.  
     */
    public static Integer[] mergeSort(Integer[] a)  throws NullPointerException {
        return(mergeSort(a, 0, a.length-1));
    }
    
    /* Sorts the input subarray of Integers a[p...q] using MergeSort and returns result.
     * Sorting is stable.
     */
    private static Integer[] mergeSort(Integer[] a, int p, int q) {
        int r = (p+q)/2;
        Integer[] b1,b2;

        if (p > q) { //Handle arrays of size 0
            b1 = new Integer[0];
            return b1;
        }
        if (p == q) { //Handle arrays of size 1
            b1 = new Integer[1];
            b1[0] = a[p];
            return b1;
        }
        b1 = mergeSort(a, p, r);
        b2 = mergeSort(a, r+1, q);
        return merge(b1, b2);
    }
    
    /* Merges two sorted arrays of Integers into a single sorted array.  Given two
     * equal elements, one in a and one in b, the element in a precedes the element in b.
     */
    private static Integer[] merge(Integer[] a, Integer[] b) {
        Integer[] c = new Integer[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = b[j++];
        }
        return (c);
    }
}
