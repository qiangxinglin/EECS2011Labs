package A1Q3S;
import java.util.*;

/**
 * Specializes the stack data structure for comparable elements, and provides
 * a method for determining the minimum element on the stack in O(1) time.
 * @author jameselder
 * @param <E> 
 */
public class MinStack<E extends Comparable<E>> extends Stack<E> {

    private final Stack<E> minStack;

    public MinStack() {
        minStack = new Stack<>();
    }

    @Override
    public E push(E element) {
        super.push(element);
        if (minStack.empty() || element.compareTo(minStack.peek()) <= 0) {
            minStack.push(element);
        }
        return element;
    }

    /* @exception  EmptyStackException  if this stack is empty. */
    @Override
    public synchronized E pop()  throws EmptyStackException {
        E element;
        element = super.pop();
        if (element.equals(minStack.peek()))
            minStack.pop();
        return element;
    }

    /* Returns the minimum value currently on the stack. */
    /* @exception  EmptyStackException  if this stack is empty. */
    public synchronized E min() throws EmptyStackException {
        return minStack.peek();
    }
}
