package ma.enset.api.web;

import lombok.AllArgsConstructor;
import ma.enset.api.Exceptions.Users.UserNotFoundException;
import ma.enset.api.entities.Test;
import ma.enset.api.entities.User;
import ma.enset.api.service.User.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {
    private UserService userService;


    /*all users*/
    @GetMapping("/users")
    public List<User> getAllUsers() {

        return userService.getAll();
    }

    @PostMapping("/users")
    ResponseEntity<User> addNewUser(@Valid @RequestBody User user) {
        System.out.println(user);
        userService.addNewUser(user);
        return ResponseEntity.ok(user);
    }


    @GetMapping("/user/{id}")
    User getUser(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/user/{id}")
    User updateUser(@Valid @RequestBody User newUser, @PathVariable long id) {
        return userService.updateUser(newUser, id);
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable long id) {
        return userService.deleteUserById(id);

    }

    @GetMapping("/users/{id}/tests")
    List<Test> testsByUser(@PathVariable long id){
        User user = userService.getUserById(id);
        if(user==null){
            throw new UserNotFoundException(id);
        }
        return user.getPassedTests();
    }
}
