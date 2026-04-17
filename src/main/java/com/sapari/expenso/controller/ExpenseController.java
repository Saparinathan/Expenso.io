package com.sapari.expenso.controller;

import com.sapari.expenso.dto.ExpenseDTO;
import com.sapari.expenso.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/expenso")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    //Add Expense
    @PostMapping("/add-expense")
    public ResponseEntity<ExpenseDTO> save(@RequestBody @Valid ExpenseDTO expenseDTO) {
        ExpenseDTO savedExpense = expenseService.save(expenseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedExpense);
    }

    //Find Expense
    @GetMapping("/view-expense")
    public ResponseEntity<List<ExpenseDTO>> findAll() {
        List<ExpenseDTO> expenses = expenseService.findAll();
        return ResponseEntity.ok(expenses);
    }

    //Find Expense By Id
    @GetMapping("/view-expense/{id}")
    public ResponseEntity<ExpenseDTO> findById(@PathVariable Long id) {
        ExpenseDTO findExpenseById = expenseService.findById(id);
        return ResponseEntity.ok(findExpenseById);
    }

    //Update Expense
    @PutMapping("/update-expense/{id}")
  public ResponseEntity<ExpenseDTO> update(@PathVariable Long id,@RequestBody @Valid ExpenseDTO expenseDTO) {
        ExpenseDTO updatedExpense = expenseService.update(id, expenseDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedExpense);
    }

    //Delete All Expenses
    @DeleteMapping("/delete-expense")
    public ResponseEntity<Void> deleteAll(){
        boolean deleteAll = expenseService.deleteAll();
        return ResponseEntity.status(deleteAll ? HttpStatus.NO_CONTENT : HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    //Delete Expense By id
    @DeleteMapping("/delete-expense/{id}")
    public ResponseEntity<ExpenseDTO> deleteById(@PathVariable("id") Long id){
        boolean deleted = expenseService.delete(id);
        return ResponseEntity.status(deleted ? 200 : 500 ).build();
    }
}
