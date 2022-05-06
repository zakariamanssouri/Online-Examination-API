package ma.enset.api.Exceptions.Tests;

public class TestNotFoundException extends RuntimeException {
    public TestNotFoundException() {
        super("not found");
    }
}
