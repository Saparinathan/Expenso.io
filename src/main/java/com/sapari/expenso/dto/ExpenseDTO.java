package com.sapari.expenso.dto;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(example = "1")
    private Long id;
    @Schema(example = "350")
      private BigDecimal amount;
    @Schema(example = "Cinema")
    private String category;
    @Schema(example = "2026-05-29")
    private LocalDate date;
    private LocalDateTime createdAt;
    @Schema(example = "Going to Imax Cinema's")
    private String description;
}