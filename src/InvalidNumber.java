/**
 * Class Invalid number
 */

public class InvalidNumber extends RuntimeException {
    // // if the Exception is raised we call the super constructor
    public InvalidNumber()  {
        super("The file contains invalid numbers");
    }
}

