package A2Q1S;
import java.util.*;
/**
 * Represents a sorted integer array.  Provides a method, kpairSum, that
 * determines whether the array contains two elements that sum to a given
 * integer k.  Runs in O(n) time, where n is the length of the array.
 * @author jameselder
 */
public class SortedIntegerArray {

    protected int[] sortedIntegerArray;

    public SortedIntegerArray() {
    }

   public SortedIntegerArray(int[] integerArray) throws NullPointerException {
        sortedIntegerArray = integerArray.clone();
        Arrays.sort(sortedIntegerArray);
    }

/**
 * Determines whether the array contains two elements that sum to a given
 * integer k. Runs in O(n) time, where n is the length of the array.
 * @author jameselder
 */
    public boolean kPairSum(int k) {
        return kPairSumInterval(k, 0, sortedIntegerArray.length-1);
    }

    private boolean kPairSumInterval(Integer k, int i, int j) {
        long sum;
        if (i >= j) {
            return false;
        }
        sum = (long) sortedIntegerArray[i] + (long) sortedIntegerArray[j];
        if (sum == k) {
            return true;
        } else if (sum < k) {
            return kPairSumInterval(k, i + 1, j);
        } else {
            return kPairSumInterval(k, i, j - 1);
        }
    }
}