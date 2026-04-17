package com.sapari.expenso.model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@Table(name = "expenses")
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseEntity {
@Id
@SequenceGenerator(name = "expenses_sequence", sequenceName = "expenses_sequence", allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenses_sequence")


@Column(name = "id", unique = true, updatable = false)
      private Long id;

@Column(name = "amount", nullable = false)
      private BigDecimal amount;

@Column(name = "category", nullable = false)
       private String category;

@Column(name = "date", nullable = false)
        private LocalDate date;

@CreationTimestamp
@Column(name = "createdAt", updatable = false)
              private LocalDateTime createdAt;

@Column(name = "description", columnDefinition = "TEXT")
      private String description;


}
