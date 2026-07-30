package com.sapari.expenso.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ExpenseRequestDTO  {

    @Schema(description = "Expense amount", example = "350")

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than zero")
    @Digits(integer = 10, fraction = 2, message = "Amount can have up to 10 digits and 2 decimal places")
    private BigDecimal amount;

    @Schema(description = "Expense category", example = "Cinema")

    @NotBlank(message = "Category is required")
    @Size(min = 3, max = 30, message = "Category must be between 3 and 30 characters")
    private String category;

    @Schema(description = "Expense date", example = "2026-05-29")

    @NotNull(message = "Date is required")
    @PastOrPresent(message = "Expense date can't be in future")
    private LocalDate date;

    @Schema(description = "Expense description", example = "Going to Imax Cinema's")

    @Size(max = 200, message = "Description can't exceed 200 characters")
    private String description;


}
