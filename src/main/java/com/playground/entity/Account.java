package com.playground.entity;

import com.playground.domain.AccountStatus;
import com.playground.domain.AccountType;
import com.playground.domain.DateTimeConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Currency;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Account", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"accountId"})
})
public class Account {
    @Id
    @Column
    private Integer accountId;
    @Column
    private AccountType accountType;
    @Column
    private String accountNumber;
    @Column
    private AccountStatus status;
    @Column
    private Float balance;
    @Column
    private Currency currency;
    @Column
    private LocalDateTime lastActivityDate = LocalDateTime.now();

    public OffsetDateTime getLastActivityDate() {
        return DateTimeConverter.toOffsetDateTime(this.lastActivityDate);
    }
}
