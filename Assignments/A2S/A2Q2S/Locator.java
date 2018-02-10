package A2Q2S;

/**
 * Interface for locating location-aware entries with integer locations.
 * @author elder
 */
public interface Locator<E> {    
    public int get(E e);
    public void set (E e, int pos);
}
