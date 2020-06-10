package com.techChallenge.techgig.controller;


import com.techChallenge.techgig.beans.Answer;
import com.techChallenge.techgig.beans.Question;
import com.techChallenge.techgig.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("*")
@EnableAutoConfiguration
public class SampleController {

    @Autowired
    IService iService;

    @GetMapping(value = "/oneToone")
    public void bookMeetingRoom()  throws Exception {
        Answer answer = new Answer();

        answer.setAnswerName("Java is a programming language");
        answer.setPostedBy("Ravi malik");

        Answer ans2=new Answer();
        ans2.setAnswerName("Java is a platform");
        ans2.setPostedBy("Sudhir Kumar");

        Answer ans3=new Answer();
        ans3.setAnswerName("Servlet is an Interface");
        ans3.setPostedBy("Jai Kumar");

        Answer ans4=new Answer();
        ans4.setAnswerName("Servlet is an API");
        ans4.setPostedBy("Arun");

        ArrayList<Answer> list1=new ArrayList<Answer>();
        list1.add(answer);
        list1.add(ans2);

        ArrayList<Answer> list2=new ArrayList<Answer>();
        list2.add(ans3);
        list2.add(ans4);


        Question question1=new Question();
        question1.setqName("What is Java?");
        question1.setAnswers(list1);

        Question question2=new Question();
        question2.setqName("What is Servlet?");
        question2.setAnswers(list2);

        iService.saveData(question1);
        iService.saveData(question2);






    }
}
