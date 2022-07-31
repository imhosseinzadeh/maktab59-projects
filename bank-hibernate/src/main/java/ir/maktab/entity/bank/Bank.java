package ir.maktab.entity.bank;

import ir.maktab.entity.BaseEntity;
import ir.maktab.entity.customer.Customer;
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
public class Bank extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Branch> branches = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Customer> customers = new HashSet<>();

    public void setCustomers(Set<Customer> customers) {
        customers.forEach(this::addCustomer);
        this.customers = customers;
    }

    public void setBranches(Set<Branch> branches) {
        branches.forEach(this::addBranch);
        this.branches = branches;
    }

    public void addCustomer(Customer customer) {
        customer.getBanks().add(this);
        this.customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        this.customers.remove(customer);
        customer.getBanks().remove(this);
    }

    public void addBranch(Branch branch) {
        branch.setBank(this);
    }

    public void removeBranch(Branch branch) {
        this.branches.remove(branch);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
