package com.example.web;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Foy Lian
 * Date: 2016-12-02
 * Time: 22:40
 */
@RestController
public class HelloBoot {
    @GetMapping("/greet/")
    public String greeting() {
        return "Hello World!";
    }

    @GetMapping("/user/")
    public String users()
    {
        return "haha , many many users!";
    }
}
