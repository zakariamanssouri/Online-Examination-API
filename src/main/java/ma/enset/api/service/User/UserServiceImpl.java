package ma.enset.api.service.User;

import lombok.AllArgsConstructor;
import ma.enset.api.Exceptions.Users.UserAlreadyExistException;
import ma.enset.api.Exceptions.Users.UserNotFoundException;
import ma.enset.api.entities.User;
import ma.enset.api.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User addNewUser(@Valid User user) {
        User retreivedUser = userRepository.findByUsername(user.getUsername());

        if (retreivedUser == null) {
            return userRepository.save(user);
        } else throw new UserAlreadyExistException(user.getUsername());
    }

    @Override
    public User getUserById(long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException(id);
        } else return user;

    }

    @Override
    public User updateUser(User newUser, long id) {
        User oldUser = userRepository.findById(id).orElse(null);
        if (oldUser == null) {
            throw new UserNotFoundException(id);
        }
        oldUser.setFullname(newUser.getFullname());
        oldUser.setUsername(newUser.getUsername());
        oldUser.setPassword(newUser.getPassword());
        oldUser.setEmail(newUser.getEmail());
        return userRepository.save(newUser);
    }

    @Override
    public String deleteUserById(long id) {
        User retreivedUser = userRepository.findById(id).orElse(null);

        if (retreivedUser == null) {
            throw new UserNotFoundException(id);
        }
        else {
            userRepository.delete(retreivedUser);
        }
        return "success";
    }
}
