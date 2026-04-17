package com.sapari.expenso.dto;
import com.sapari.expenso.model.ExpenseEntity;
import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper {
    public ExpenseEntity toEntity(ExpenseDTO expenseDTO){
        return ExpenseEntity.builder()
                .amount(expenseDTO.getAmount())
                .category(expenseDTO.getCategory())
                .date(expenseDTO.getDate())
                .description(expenseDTO.getDescription())
                .build();
    }
    public ExpenseDTO toDto(ExpenseEntity expenseEntity){
        return new ExpenseDTO(
        expenseEntity.getId(),
        expenseEntity.getAmount(),
        expenseEntity.getCategory(),
        expenseEntity.getDate(),
        expenseEntity.getCreatedAt(),
        expenseEntity.getDescription()
        );
    }
}


