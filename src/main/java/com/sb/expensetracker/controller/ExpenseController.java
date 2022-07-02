package com.sb.expensetracker.controller;

import com.sb.expensetracker.entity.Expense;
import com.sb.expensetracker.service.ExpenseService;
import com.sb.expensetracker.util.ExpenseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RestController
@Slf4j
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    //get expense list
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(Pageable pageable) {
        log.info("getExpenses method in ExpenseController class : ");
        return expenseService.getAllExpenses(pageable).toList();
    }

    //get expense through id
    @ResponseStatus(value = HttpStatus.FOUND)
    @GetMapping("/expense/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        log.info(" getExpenseById method in ExpenseController class with Expense id : " + id);
        return expenseService.getExpenseById(id);
    }

    // delete expense thourgh id
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/expenses")
    public String deleteExpenseById(@RequestParam Long id) {
        log.info(" deleteExpenseById method in ExpenseController class with Expense id : " + id);
        return expenseService.deleteExpenseById(id);
    }

    //create expense
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/expenses")
    public Expense createExpense(@RequestBody ExpenseDto expenseDto) {
        log.info(" createExpense method in ExpenseControlle class : ");
        return expenseService.createExpense(expenseDto);
    }

    //update expense
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping("expenses/{id}")
    public Expense updateExpense(@RequestBody ExpenseDto expenseDto, @PathVariable Long id) {
        log.info(" updateExpense method in ExpenseController class with id : " + id);
        return expenseService.updateExpense(expenseDto, id);
    }

    //update expense
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PatchMapping("/expenses/{id}/{amount}")
    public Expense updateExpenseAmount(@PathVariable Long id, @PathVariable BigDecimal amount) {
        log.info("updateExpenseAmount method in ExpenseController class with id : " + id);
        return expenseService.updateExpenseAmount(id, amount);
    }

    //
    @GetMapping("/expenses/category")
    public List<Expense> getAllExpensesByCategory(@RequestParam String category, Pageable pageable) {
        log.info("");
        return expenseService.getAllExpensesByCategory(category, pageable).toList();
    }

    //
    @GetMapping("/expenses/name")
    public List<Expense> getAllExpensesByName(@RequestParam String name, Pageable pageable) {
        log.info("");
        return expenseService.getAllExpensesByName(name, pageable).toList();
    }

    //check
    @GetMapping("/test")
    public String check() {
        return "its working!";
    }

}
