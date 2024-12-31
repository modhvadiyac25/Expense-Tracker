package com.learning.springbootmongodbtutorial.service;

import com.learning.springbootmongodbtutorial.model.Expense;
import com.learning.springbootmongodbtutorial.repository.ExpenseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense){
        expenseRepository.insert(expense);
    }
    public void updateExpense(Expense expense){
        Expense saveExpense = expenseRepository.findById(expense.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot find expense by id %s", expense.getId())));
        saveExpense.setExpenseAmount(expense.getExpenseAmount());
        saveExpense.setExpenseName(expense.getExpenseName());
        saveExpense.setExpenseCategory(expense.getExpenseCategory());
        expenseRepository.save(saveExpense);
    }

    public List<Expense> getAllExpense(){
        return expenseRepository.findAll();
    }
    public Expense getExpenseByName(String name){
        return expenseRepository.findByName(name).orElseThrow(()-> new RuntimeException(String.format("Cannot find expense by name %s", name)));
    }

    public Expense getExpenseById(String id){
        return expenseRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("Cannot find expense by id %s", id)));
    }
    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    }

}
