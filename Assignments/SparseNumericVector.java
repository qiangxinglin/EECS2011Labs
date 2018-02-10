package A1Q1;
import java.util.*;

/**
 * Represents a sparse numeric vector. Elements are comprised of a (long)
 * location index an a (double) value.  The vector is maintained in increasing
 * order of location index, which facilitates numeric operations like
 * inner products (projections).  Note that location indices can be any integer
 * from 1 to Long.MAX_VALUE.  The representation is based upon a
 * singly-linked list.
 * The following methods are supported:  iterator, getSize, getFirst,
 * add, remove, and dot, which takes the dot product of the with a second vector
 * passed as a parameter.
 * @author Edon Haziri
 */
public class SparseNumericVector implements Iterable {

    protected SparseNumericNode head = null;
    protected SparseNumericNode tail = null;
    protected long size;

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
        if (size == 0)
        	return null;
        else
        	return head.getNext();
    }
    
    /**
     * Add the element to the vector.  It is inserted to maintain the
     * vector in increasing order of index.  If an element with the same
     * index already exists, its value is updated. 
     * If an element with 0 value is passed, it is ignored.
     * @param e element to add
     */
  public void add(SparseNumericElement e) {
	  SparseNumericNode firstNode = head;
	  SparseNumericNode secondNode = new SparseNumericNode(e, null);
	  while ((firstNode.getNext().getElement().getIndex()) <= e.getIndex() 
			  && (firstNode.getNext() != tail)){
		  firstNode = firstNode.getNext();
	  }
	  if (e.getIndex() != firstNode.getElement().getIndex()){
		  secondNode.setNext(firstNode.getNext());
		  firstNode.setNext(secondNode);
		  size++;
	  }
	  else
		  firstNode.getElement().setValue(e.getValue());
    }

  
    /**
     * If an element with the specified index exists, it is removed and the
     * method returns true.  If not, it returns false.
     *
     * @param index of element to remove
     * @return true if removed, false if does not exist
     */
    public boolean remove(Long index) {
        SparseNumericNode firstNode = head;
        while (index >= firstNode.getNext().getElement().getIndex()){
        	firstNode = firstNode.getNext();
        }
        if ((index != firstNode.getElement().getIndex() 
        		&& (firstNode.getNext() != tail)))
        		{
        	return false;
        }
        else {
        	firstNode.setNext(firstNode.getNext().getNext());
        	size++;
        	return true;
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

    public double dot (SparseNumericVector Y) {
    	SparseNumericElement eX;
    	SparseNumericElement eY;
    	double sum = 0;
    	Iterator<SparseNumericElement> itX = this.iterator();
    	Iterator<SparseNumericElement> itY = Y.iterator();
    	if (this.getSize() == 0 || Y.getSize() == 0){
    		sum = 0;
    	}
    	else{
    		eX = itX.next();
    		eY = itY.next();
    		while (eX != null && eY != null){
    			if (eY.getIndex() == eX.getIndex()){
    					sum += (eX.getValue() * eY.getValue());
    					if (!itX.hasNext()){
    						eX = null;
    					}
    					else{
    						eX = itX.next();
    					}
    					if (!itY.hasNext()){
    						eY = null;
    					}
    					else
    						eY = itY.next();
    					}
    			else if (eY.getIndex() > eX.getIndex()){
    				if (itX.hasNext()){
    					eX = itX.next();
    				}
    				else{
    					eX = null;
    					}
    				}
    				else {
    					if(itY.hasNext()){
    						eY = itY.next();
    					}
    					else
    						eY = null;
    				}
    		}
    	}
		return sum;
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
