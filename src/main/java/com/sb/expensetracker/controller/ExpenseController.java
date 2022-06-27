package com.sb.expensetracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/v1")
@RestController
public class ExpenseController {

    @GetMapping("/test")
    public String check(){
        return "its working!";
    }
}
