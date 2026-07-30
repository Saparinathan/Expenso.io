package com.sapari.expenso.controller;


import com.sapari.expenso.dto.ExpenseRequestDTO;
import com.sapari.expenso.dto.ExpenseResponseDTO;
import com.sapari.expenso.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/expenso")
@Tag(name = "Expense Management", description = "APIs for managing expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    //Add Expense
    @Operation(summary = "Create a new expense", description = "Add a new expense to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Expense created successfully!",
                    content = @Content(schema = @Schema(implementation = ExpenseRequestDTO.class))),
            @ApiResponse(responseCode = "400", description = "Validation failed - invalid or missing fields"),
            @ApiResponse(responseCode = "500", description = "Internal server error")

    })
    @PostMapping("/expenses")
    public ResponseEntity<ExpenseResponseDTO> save(@RequestBody @Valid ExpenseRequestDTO expenseDTO) {
        ExpenseResponseDTO savedExpense = expenseService.save(expenseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedExpense);
    }

    //Find All Expenses
    @Operation(summary = "View all expenses", description = "View all expenses that stored in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All expenses are retrieved successfully!",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = ExpenseRequestDTO.class)))),
            @ApiResponse(responseCode = "204", description = "There is no expenses are stored")
    })

    @GetMapping("/expenses")
    public ResponseEntity<List<ExpenseResponseDTO>> findAll() {
        List<ExpenseResponseDTO> expenses = expenseService.findAll();
        if(expenses.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(expenses);
    }

    //Find Expense By Id
    @Operation(summary = "View expense by id", description = "View expense by id that stored in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expense is retrieved successfully by using id",
                    content = @Content(schema = @Schema(implementation = ExpenseRequestDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @GetMapping("/expenses/{id}")
    public ResponseEntity<ExpenseResponseDTO> findById(@PathVariable Long id) {
        ExpenseResponseDTO findExpenseById = expenseService.findById(id);
        return ResponseEntity.ok(findExpenseById);
    }

    //Update Expense
    @Operation(summary = "Update expense", description = "Update an existing expense by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "An expense successfully updated by id",
                    content = @Content(schema = @Schema(implementation = ExpenseRequestDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @PutMapping("/expenses/{id}")
    public ResponseEntity<ExpenseResponseDTO> update(@PathVariable Long id,@RequestBody @Valid ExpenseRequestDTO expenseDTO) {
        ExpenseResponseDTO updatedExpense = expenseService.update(id, expenseDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedExpense);
    }



    //Delete Expense By id
    @Operation(summary = "Delete expense by id", description = "Delete an expense by id that stored in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "An expense deleted successfully by id",
                    content = @Content(schema = @Schema(implementation = ExpenseRequestDTO.class))),
            @ApiResponse(responseCode = "404", description = "Expense not found in this id")
    })
    @DeleteMapping("/expenses/{id}")
    public ResponseEntity<ExpenseResponseDTO> deleteById(@PathVariable("id") Long id){
        boolean deleted = expenseService.delete(id);
        return ResponseEntity.status(deleted ? 200 : 404 ).build();
    }
}
