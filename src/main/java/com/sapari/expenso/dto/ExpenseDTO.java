package com.sapari.expenso.dto;
import lombok.*;

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
public class ExpenseDTO implements Serializable {
    private static final long serialVersionUID = 1L;
      private Long id;
      private BigDecimal amount;
    private String category;
    private LocalDate date;
    private LocalDateTime createdAt;
    private String description;
}