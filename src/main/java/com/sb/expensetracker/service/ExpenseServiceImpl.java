package com.sb.expensetracker.service;

import com.sb.expensetracker.entity.Expense;
import com.sb.expensetracker.repository.ExpenseRepository;
import com.sb.expensetracker.util.ExpenseDto;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Builder
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Page<Expense> getAllExpenses(Pageable pageble) {
        log.info("getExpenses method in ExpenseServiceImpl class :");
        return expenseRepository.findAll(pageble);
    }

    @Override
    public Expense getExpenseById(Long id) {
        log.info("getExpenseById method in ExpenseServiceImpl class with Expense Id : " + id);
        Optional<Expense> expenseId = expenseRepository.findById(id);
        if (expenseId.isPresent()) {
            return expenseId.get();
        }
        throw new RuntimeException("Expense is not found for the id : " + id);
    }

    @Override
    public String deleteExpenseById(Long id) {
        log.info("deleteExpenseById method in ExpenseServiceImpl class with Expense Id : " + id);
        Optional<Expense> expense = expenseRepository.findById(id);
        if (expense.isPresent()) {
            expenseRepository.deleteById(id);
            return "Successfully deleted the expense!";
        }
        throw new RuntimeException("Expense is not found for the id : " + id);
    }

    @Override
    public Expense createExpense(ExpenseDto expenseDto) {
        log.info(" createExpense method in ExpenseServiceImpl class: ");
        Expense expense = Expense.builder()
                .name(expenseDto.getName())
                .category(expenseDto.getCategory())
                .description(expenseDto.getDescription())
                .date(Date.valueOf(LocalDate.now()))
                .amount(expenseDto.getAmount())
                .build();
        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpense(ExpenseDto expenseDto, Long id) {
        log.info("updateExpense method in ExpenseServiceImpl class with id : " + id);
        Optional<Expense> expense = expenseRepository.findById(id);
        if (expense.isPresent()) {
            Expense expense1 = Expense.builder()
                    .name(expenseDto.getName())
                    .amount(expenseDto.getAmount())
                    .category(expenseDto.getCategory())
                    .description(expenseDto.getDescription())
                    .id(expense.get().getId())
                    .build();
            return expenseRepository.save(expense1);
        }
        throw new RuntimeException("Invalid expense id : " + id);
    }

    @Override
    public Expense updateExpenseAmount(Long id, BigDecimal amount) {
        log.info("updateExpenseAmount method in ExpenseServiceImpl class with id : " + id);
        Optional<Expense> expense = expenseRepository.findById(id);
        if (expense.isPresent()) {
            expense.get().setAmount(amount);
            expense.get().setDate(Date.valueOf(LocalDate.now()));
            return expenseRepository.save(expense.get());
        }
        throw new RuntimeException("Invalid expense id : " + id);
    }


}
