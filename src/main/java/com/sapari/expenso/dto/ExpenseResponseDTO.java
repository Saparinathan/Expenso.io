package com.sapari.expenso.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseResponseDTO  {

    @Schema(description = "Expense id", example = "1")
    private Long id;

    @Schema(description = "Expense amount", example = "350.06")
    private BigDecimal amount;

    @Schema(description = "Expense category", example = "Cinema")
    private String category;

    @Schema(description = "Expense date", example = "2026-07-30")
    private LocalDate date;

    private LocalDateTime createdAt;

    @Schema(description = "Expense description", example = "Going to Imax Cinema")
    private String description;




}
