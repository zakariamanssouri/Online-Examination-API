package ma.enset.api.web;

import lombok.AllArgsConstructor;
import ma.enset.api.entities.Question;
import ma.enset.api.entities.Test;
import ma.enset.api.service.Question.QuestionService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class QuestionController {
    private QuestionService questionService;


    @GetMapping("/question/{id}")
    Question getQuestion(@PathVariable long id) {
        return questionService.getQuestion(id);
    }
    @PutMapping("/question/{id}")
    Question updateQuestion(@Valid @RequestBody Question newQuestion, @PathVariable long id) {
        return questionService.updateQuestion(newQuestion,id);
    }


}
