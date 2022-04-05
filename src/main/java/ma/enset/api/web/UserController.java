package ma.enset.api.web;

import lombok.AllArgsConstructor;
import ma.enset.api.Exceptions.UserNotFoundException;
import ma.enset.api.entities.User;
import ma.enset.api.repositories.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Transactional
public class UserController {
    private UserRepository userRepository;


    /*all users*/
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public String addNewUser(@Validated @RequestBody User user, BindingResult bindingResult) {
        if (user.getUsername().equals("")) return "username cannot be null";
        if (bindingResult.hasErrors()) {
            return bindingResult.toString();
        }
        try {
            userRepository.save(user);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "success";
    }


    @GetMapping("/user/{id}")
    User getUser(@PathVariable long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable long id) {
        User oldUser = userRepository.findById(id).orElse(null);
        if (oldUser!=null) {
            String username = oldUser.getUsername().equals("")?newUser.getUsername():newUser.getUsername();
            System.out.println(username);

        } else throw new UserNotFoundException(id);
        return userRepository.save(newUser);
    }



    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException(id);
        } else userRepository.delete(user);
    }
}