package ma.enset.api.web;

import lombok.AllArgsConstructor;
import ma.enset.api.Exceptions.Tests.TestNotFoundException;
import ma.enset.api.Exceptions.Users.UserNotFoundException;
import ma.enset.api.entities.Test;
import ma.enset.api.entities.User;
import ma.enset.api.service.Test.TestService;
import ma.enset.api.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TestController {
    private TestService testService;
    private UserService userService;

    /*all tests*/
    @GetMapping("/tests")
    public List<Test> getAllTests() {
        return testService.getAll();
    }

    @PostMapping("/test")
    ResponseEntity<String> addNewTest(@Valid @RequestBody Test test) {
        testService.addNewTest(test);
        return ResponseEntity.ok("test created");
    }

    @GetMapping("/test/{id}")
    Test getTest(@PathVariable long id) {
        return testService.getTestById(id);
    }

    @PutMapping("/test/{id}")
    Test updateUser(@Valid @RequestBody Test newTest, @PathVariable long id) {
        return testService.updateTest(newTest, id);
    }

    @DeleteMapping("/test/{id}")
    String deleteTest(@PathVariable long id) {
        return testService.deleteTestById(id);
    }

    @GetMapping("/tests/{id}/users")
    List<User> testsByUser(@PathVariable long id){
        Test test= testService.getTestById(id);
        if(test==null){
            throw new TestNotFoundException();
        }
        return test.getUsers();
    }



}
