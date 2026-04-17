package com.sapari.expenso.service;

import com.sapari.expenso.dto.ExpenseDTO;
import com.sapari.expenso.dto.ExpenseMapper;
import com.sapari.expenso.model.ExpenseEntity;
import com.sapari.expenso.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ExpenseDTO save(ExpenseDTO expenseDTO) {
        ExpenseEntity expenseEntity = expenseMapper.toEntity(expenseDTO);
        ExpenseEntity savedEntity = expenseRepository.save(expenseEntity);
        return expenseMapper.toDto(savedEntity);
    }

    //Find All Expenses
    public List<ExpenseDTO> findAll() {
        return expenseRepository.findAll()
                .stream()
                .map(expenseMapper::toDto)
                .collect(Collectors.toList());
    }

    //Find Expense By id
    public ExpenseDTO findById(Long id) {
        ExpenseEntity expenseEntity = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found for id " + id));
        return expenseMapper.toDto(expenseEntity);
    }

    //Update Expense
   public ExpenseDTO update(Long id, ExpenseDTO expenseDTO) {
        ExpenseEntity existingEntity = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id" + id));
                existingEntity.setAmount(expenseDTO.getAmount());
                existingEntity.setCategory(expenseDTO.getCategory());
                existingEntity.setDate(expenseDTO.getDate());
                existingEntity.setDescription(expenseDTO.getDescription());
        ExpenseEntity savedEntity = expenseRepository.save(existingEntity);
        return expenseMapper.toDto(savedEntity);
    }


    //Delete All Expenses
   public boolean deleteAll(){
       expenseRepository.deleteAll();
       return expenseRepository.count() == 0;
   }

    //Delete Expense By id
    public boolean delete(Long id){
        expenseRepository.deleteById(id);
        return !expenseRepository.existsById(id);
    }

    }



