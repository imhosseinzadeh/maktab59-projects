package ir.maktab.entity.customer;

import ir.maktab.entity.BaseEntity;
import ir.maktab.entity.bank.Branch;
import ir.maktab.entity.transaction.Transaction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Account extends BaseEntity<String> {

    @Id
    private String id;

    private Double amount;

    @ManyToOne(optional = false)
    private Customer customer;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private CreditCard creditCard;

    @ManyToOne(optional = false)
    private Branch branch;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountState state;

    @OneToMany(mappedBy = "sourceAccount", cascade = CascadeType.ALL)
    private Set<Transaction> transactions;

    public Account(String id, Customer customer, Branch branch, AccountState state) {
        this.id = id;
        this.customer = customer;
        this.branch = branch;
        this.state = state;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        customer.getAccounts().add(this);
    }

    public void setCreditCard(CreditCard creditCard) {
        creditCard.setAccount(this);
        this.creditCard = creditCard;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
        branch.getAccounts().add(this);
    }

    public void setTransactions(Set<Transaction> transactions) {
        transactions.forEach(this::addTransaction);
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        transaction.setSourceAccount(this);
    }

    public void removeTransaction(Transaction transaction) {
        this.transactions.remove(transaction);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", customer=" + customer +
                ", creditCard=" + creditCard +
                ", branch=" + branch +
                ", state=" + state +
                '}';
    }

}
