package ma.enset.api.Exceptions.Tests;

public class TestAlreadyExistException extends Exception {
    public TestAlreadyExistException(String message) {
        super("already exist");
    }
}
