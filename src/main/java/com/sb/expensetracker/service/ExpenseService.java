package com.sb.expensetracker.service;

import com.sb.expensetracker.entity.Expense;
import com.sb.expensetracker.util.ExpenseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ExpenseService {

    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    String deleteExpenseById(Long id);

    Expense createExpense(ExpenseDto expenseDto);
}
