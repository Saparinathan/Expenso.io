package com.sapari.expenso.service;

import com.sapari.expenso.dto.ExpenseMapper;
import com.sapari.expenso.dto.ExpenseRequestDTO;
import com.sapari.expenso.dto.ExpenseResponseDTO;
import com.sapari.expenso.exception.ExpenseNotFoundException;
import com.sapari.expenso.model.ExpenseEntity;
import com.sapari.expenso.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {
    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    ExpenseMapper expenseMapper;

    //Add Expense
    public ExpenseResponseDTO save(ExpenseRequestDTO expenseDTO) {
        ExpenseEntity expenseEntity = expenseMapper.toEntity(expenseDTO);
        ExpenseEntity savedEntity = expenseRepository.save(expenseEntity);
        return expenseMapper.toDto(savedEntity);
    }

    //Find All Expenses
    public List<ExpenseResponseDTO> findAll() {
        return expenseRepository.findAll()
                .stream()
                .map(expenseMapper::toDto)
                .collect(Collectors.toList());
    }

    //Find Expense By id
    public ExpenseResponseDTO findById(Long id) {
        ExpenseEntity expenseEntity = expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException("Expense with id " + id + " not found"));
        return expenseMapper.toDto(expenseEntity);
    }

    //Update Expense
    public ExpenseResponseDTO update(Long id, ExpenseRequestDTO expenseDTO) {
        ExpenseEntity existingEntity = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id" + id));
        existingEntity.setAmount(expenseDTO.getAmount());
        existingEntity.setCategory(expenseDTO.getCategory());
        existingEntity.setDate(expenseDTO.getDate());
        existingEntity.setDescription(expenseDTO.getDescription());
        ExpenseEntity savedEntity = expenseRepository.save(existingEntity);
        return expenseMapper.toDto(savedEntity);
    }

    //Delete Expense By id
    public boolean delete(Long id){
        if(!expenseRepository.existsById(id)){
            return false;
        }
        expenseRepository.deleteById(id);
        return true;
    }

}