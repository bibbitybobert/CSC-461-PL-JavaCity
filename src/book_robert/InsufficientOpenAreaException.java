package book_robert;

/**
 * Custom Exception for if there are not enough Open areas in a city to accept a Rezone visitor
 */
public class InsufficientOpenAreaException extends Exception{
    /**
     * Default constructor
     */
    public InsufficientOpenAreaException(){
        super();
    }
}
