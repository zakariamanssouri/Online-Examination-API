package ma.enset.api.web;

import lombok.AllArgsConstructor;
import ma.enset.api.Exceptions.Tests.TestNotFoundException;
import ma.enset.api.Exceptions.Users.UserNotFoundException;
import ma.enset.api.entities.Question;
import ma.enset.api.entities.Test;
import ma.enset.api.entities.User;
import ma.enset.api.service.Question.QuestionService;
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
    private QuestionService questionService;

    /*all tests*/
   /* @GetMapping("/tests")
    public List<Test> getAllTests() {
        return testService.getAll();
    }*/
    @GetMapping("/test/questions")
    public List<Question> getAllQuestions(@Valid @RequestBody Test test){
        return questionService.getAllQuestions(test);
    }
    @PostMapping("/test/question")
    ResponseEntity<String> addNewQuestion(@Valid @RequestBody Question question) {
        questionService.addNewQuestion(question);
        return ResponseEntity.ok("question added");
    }

    @PostMapping("/tests")
    ResponseEntity<String> addNewTest(@Valid @RequestBody Test test) {
        testService.addNewTest(test);
        return ResponseEntity.ok("test created");
    }

    @GetMapping("/tests/{id}")
    Test getTest(@PathVariable long id) {
        return testService.getTestById(id);
    }

    @PutMapping("/tests/{id}")
    Test updateUser(@Valid @RequestBody Test newTest, @PathVariable long id) {
        return testService.updateTest(newTest, id);
    }

    @DeleteMapping("/tests/{id}")
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

    @GetMapping("/tests")
    List<Test> getTestsByKeyword(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return testService.getTestsByKeyword(keyword);
    }

}
