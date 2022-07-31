package ir.maktab.entity.bank;

import ir.maktab.entity.BaseEntity;
import ir.maktab.entity.customer.Account;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Branch extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Bank bank;

    @OneToOne(mappedBy = "branch", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private BranchHead branchHead;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employee> employees = new HashSet<>();

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Account> accounts = new HashSet<>();


    public void setBank(Bank bank) {
        this.bank = bank;
        bank.getBranches().add(this);
    }

    public void setBranchHead(BranchHead branchHead) {
        branchHead.setBranch(this);
        this.branchHead = branchHead;
    }

    public void setEmployees(Set<Employee> employees) {
        employees.forEach(this::addEmployee);
        this.employees = employees;
    }

    public void setAccounts(Set<Account> accounts) {
        accounts.forEach(this::addAccount);
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        account.setBranch(this);
    }

    public void removeAccount(Account account) {
        this.accounts.remove(account);
    }

    public void addEmployee(Employee employee) {
        employee.setBranch(this);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", bank=" + bank +
                ", branchHead=" + branchHead +
                '}';
    }

}
