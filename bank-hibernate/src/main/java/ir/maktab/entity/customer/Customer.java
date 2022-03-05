package ir.maktab.entity.customer;

import ir.maktab.entity.BaseEntity;
import ir.maktab.entity.bank.Bank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Customer extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nationalId;

    private String firstname;

    private String lastname;

    @ManyToMany(mappedBy = "customers", cascade = CascadeType.ALL)
    private Set<Bank> banks = new HashSet<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Account> accounts = new HashSet<>();

    public Customer(Long id, String nationalId) {
        this.id = id;
        this.nationalId = nationalId;
    }

    public void setBanks(Set<Bank> banks) {
        banks.forEach(this::addBank);
        this.banks = banks;
    }

    public void setAccounts(Set<Account> accounts) {
        accounts.forEach(this::addAccount);
        this.accounts = accounts;
    }

    public void addBank(Bank bank) {
        bank.addCustomer(this);
    }

    public void removeBank(Bank bank) {
        bank.removeCustomer(this);
    }

    public void addAccount(Account account) {
        account.setCustomer(this);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", nationalId='" + nationalId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

}
