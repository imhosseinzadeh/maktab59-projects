package ir.maktab.entity.transaction;


import ir.maktab.entity.BaseEntity;
import ir.maktab.entity.customer.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Transaction extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account sourceAccount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDate date;


    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
        sourceAccount.getTransactions().add(this);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", sourceAccount=" + sourceAccount +
                ", type=" + type +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }

}

