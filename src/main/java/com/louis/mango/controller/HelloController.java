package com.louis.mango.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LD
 */
@RestController
public class HelloController {

    @GetMapping(value="/hello")
    public Object hello() {
        return "Hello Mango!";
    }
    
}