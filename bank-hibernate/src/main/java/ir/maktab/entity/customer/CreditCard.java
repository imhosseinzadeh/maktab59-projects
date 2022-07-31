package ir.maktab.entity.customer;

import ir.maktab.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class CreditCard extends BaseEntity<String> {

    @Id
    private String id;

    private Integer cvv2;

    private LocalDate expDate;

    private Integer password;

    @OneToOne(optional = false)
    private Account account;

    public CreditCard(String id, Integer cvv2, LocalDate expDate, Account account) {
        this.id = id;
        this.cvv2 = cvv2;
        this.expDate = expDate;
        this.account = account;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id='" + id + '\'' +
                ", cvv2=" + cvv2 +
                ", expDate=" + expDate +
                ", password=" + password +
                ", account=" + account +
                '}';
    }

}
