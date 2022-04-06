package ma.enset.api.service.User;

import ma.enset.api.entities.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User addNewUser(User user);

    User getUserById(long id);

    User updateUser(User user, long id);

    String deleteUserById(long id);
}
