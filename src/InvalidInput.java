/**
 * Class Invalid Input
 */

class InvalidInput extends RuntimeException {
    // if the Exception is raised we call the super constructor
    public InvalidInput() {
        super("Invalid format");
    }
}
