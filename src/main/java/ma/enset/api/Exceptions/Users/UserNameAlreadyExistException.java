package ma.enset.api.Exceptions.Users;

public class UserNameAlreadyExistException extends RuntimeException {
    public UserNameAlreadyExistException(String username) {
        super(" username :"+username+" already exist");
    }
}
