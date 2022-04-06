package ma.enset.api.Exceptions.Users;

public class  UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String username) {
        super("user with username :"+username+" already exist");
    }
}
