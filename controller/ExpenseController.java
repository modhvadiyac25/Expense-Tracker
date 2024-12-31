package com.learning.springbootmongodbtutorial.controller;

import com.learning.springbootmongodbtutorial.model.Expense;
import com.learning.springbootmongodbtutorial.repository.ExpenseRepository;
import com.learning.springbootmongodbtutorial.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/create")
    public ResponseEntity addExpense(@RequestBody Expense expense){
        System.out.println("hello");
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/update")
    public ResponseEntity updateExpense(@RequestBody Expense expense){
        expenseService.updateExpense(expense);
        return ResponseEntity.ok().build();
    }
//    @GetMapping("/get")
//    public ResponseEntity<List<Expense>> getAllExpense(){
//        System.out.println("from get");
//        return ResponseEntity.ok(expenseService.getAllExpense());
//    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable String id){
        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteExpense(@PathVariable String id){
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}