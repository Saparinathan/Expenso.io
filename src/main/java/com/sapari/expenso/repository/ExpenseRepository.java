package com.sapari.expenso.repository;

import com.sapari.expenso.dto.ExpenseDTO;
import com.sapari.expenso.model.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository <ExpenseEntity, Long> {

}
