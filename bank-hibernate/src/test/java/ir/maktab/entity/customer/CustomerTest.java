package ir.maktab.entity.customer;

import ir.maktab.entity.bank.Bank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerTest {

    private static Customer customer;

    private static Bank bank;

    @BeforeAll
    static void setUp() {
        customer = new Customer(100L, "10000");

        bank = new Bank();

        Set<Customer> customerSet = new HashSet<>();
        Customer customer1 = new Customer(1L, "1111");
        Customer customer2 = new Customer(2L, "2222");
        customerSet.add(customer1);
        customerSet.add(customer2);

        bank.setCustomers(customerSet);
    }

    @Test
    void setCus_national_id() {
    }

    @Test
    void setCus_firstname() {
    }

    @Test
    void setCus_lastName() {
    }

    @Test
    void setCus_banks() {
    }

    @Test
    void setCus_accounts() {
    }

    @Test
    void addBank() {
        customer.addBank(bank);

        assertTrue(customer.getBanks().contains(bank));
        assertTrue(bank.getCustomers().contains(customer));
    }

    @Test
    void removeBank() {
    }

    @Test
    void addAccount() {
    }

    @Test
    void removeAccount() {
    }
}