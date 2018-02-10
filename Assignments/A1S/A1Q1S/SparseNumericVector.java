package A1Q1S;
import java.util.*;

/**
 * Represents a sparse numeric vector. Elements are comprised of a (long)
 * location index and a (double) value.  The vector is maintained in increasing
 * order of location index, which facilitates numeric operations like
 * inner products (projections).  Note that location indices can be any integer
 * from 1 to Long.MAX_VALUE.  The representation is based upon a
 * singly-linked list.
 * The following methods are supported:  iterator, getSize, getFirst,
 * add, remove, and project, which projects the vector onto a second vector
 * passed as a parameter.
 * @author jameselder
 */
public class SparseNumericVector implements Iterable {

    protected SparseNumericNode head = null;
    protected SparseNumericNode tail = null;
    protected long size = 0;

   /**
     * Iterator
     */
    @Override
    public Iterator<SparseNumericElement> iterator() { //iterator
        return new SparseNumericIterator(this);
    }

    /**
     * @return number of non-zero elements in vector
     */
   public long getSize() {
        return size;
    }

     /**
     * @return the first node in the list.
     */
    public SparseNumericNode getFirst() {
        return head;
    }
   
    /**
     * Add the element to the vector.  It is inserted to maintain the
     * vector in increasing order of index.  If an element with the same
     * index already exists, its value is updated. 
     * If an element with 0 value is passed, it is ignored.
     * @param e element to add
     */
    public void add(SparseNumericElement e) {
        SparseNumericNode u = new SparseNumericNode(e, null);
        SparseNumericNode v = head;
        if (e.getValue() == 0) {
            return; // vectors only store non-zero elements
        }
        if (size == 0) { //empty list
            head = u;
            tail = u;
            size++;
        } else if (u.getElement().getIndex() < head.getElement().getIndex()) {
            //insert new element at head
                head = u;
                u.setNext(v);
                size++;
            }
        else {
            while (v.getNext() != null
                    && e.getIndex() >= v.getNext().getElement().getIndex() ) {
                v = v.getNext(); //advance to insertion point
            }
            if (v.getElement().getIndex() == e.getIndex()) {
                v.getElement().setValue(e.getValue());  //index exists - update value
            } else { //insert new element
                u.setNext(v.getNext());
                v.setNext(u);
                if (v == tail) { //new element inserted at tail
                    tail = u;
                }
                size++;
            }
        }
    }

    /**
     * If an element with the specified index exists, it is removed and the
     * method returns true.  If not, it returns false.
     *
     * @param index of element to remove
     * @return true if removed, false if does not exist
     */
    public boolean remove(Long index) {
        SparseNumericNode v = head;
        if (size == 0) { //empty list
            return false;
        }
        if (index == v.getElement().getIndex()) { //remove head
            head = v.getNext();
            size--;
            if (size == 0) {
                tail = null;
            }
            return true;
        }
        while (v.getNext() != null
                && index > v.getNext().getElement().getIndex()) {
            v = v.getNext(); //advance to deletion point
        }
        if (v.getNext() != null && v.getNext().getElement().getIndex() == index) { 
            //found matchind index
            if (v.getNext() == tail) { //removing tail
                tail = v;
            }
            v.setNext((v.getNext()).getNext()); //remove node
            size--;
            return true;
        } else { //no matching node
            return false;
        }
    }

    /**
     * Returns the inner product of the vector with a second vector passed as a
     * parameter.  The vectors are assumed to reside in the same space.
     * Runs in O(m+n) time, where m and n are the number of non-zero elements in
     * each vector.
     * @param Y Second vector with which to take inner product
     * @return result of inner product
     */

    public double dot(SparseNumericVector Y) {
        Iterator<SparseNumericElement> itX = iterator();
        Iterator<SparseNumericElement> itY = Y.iterator();
        double projection = 0;
        SparseNumericElement x, y;

        if (size == 0 || Y.getSize() == 0) {
            return 0;
        } else {
            x = itX.next();
            y = itY.next();
            while (x != null && y != null) {
                if (x.getIndex() == y.getIndex()) {
                    projection += x.getValue() * y.getValue();
                    if (itX.hasNext()) {
                        x = itX.next();
                    } else {
                        x = null;
                    }
                    if (itY.hasNext()) {
                        y = itY.next();
                    } else {
                        y = null;
                    }
                } else if (x.getIndex() < y.getIndex()) {
                    if (itX.hasNext()) {
                        x = itX.next();
                    } else {
                        x = null;
                    }

                } else {
                    if (itY.hasNext()) {
                        y = itY.next();
                    } else {
                        y = null;
                    }
                }
            }
            return projection;
        }
    }

       /**
     * returns string representation of sparse vector
     */

    @Override
    public String toString() {
        String sparseVectorString = "";
        Iterator<SparseNumericElement> it = iterator();
        SparseNumericElement x;
        while (it.hasNext()) {
            x = it.next();
            sparseVectorString += "(index " + x.getIndex() + ", value " + x.getValue() + ")\n";
        }
        return sparseVectorString;
    }
}

