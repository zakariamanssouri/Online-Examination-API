package ma.enset.api.Exceptions.Tests;

public class TestAlreadyExistException extends RuntimeException {
    public TestAlreadyExistException() {
        super("already exist");
    }
}
