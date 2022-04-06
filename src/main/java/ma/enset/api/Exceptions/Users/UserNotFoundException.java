package ma.enset.api.Exceptions.Users;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(long id) {
        super("could not find user with id "+id);
    }
}




