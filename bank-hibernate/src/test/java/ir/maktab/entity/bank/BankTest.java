package ir.maktab.entity.bank;

import ir.maktab.entity.customer.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private static Branch branch;
    private static Bank bank;

    private static Set<Customer> customerSet = new HashSet<>();

    @BeforeAll
    static void setUp() {
        branch = new Branch();
        bank = new Bank();

        Customer customer1 = new Customer();
        customer1.setNationalId("1111");
        Customer customer2 = new Customer();
        customer2.setNationalId("2222");
        customerSet.add(customer1);
        customerSet.add(customer2);
    }

    @Test
    void test_setBank_name() {
        String newName = "newName";
        bank.setName(newName);
        assertEquals(newName, bank.getName());
    }

    @Test
    void test_setBank_customers() {
        bank.setCustomers(customerSet);
        assertEquals(customerSet, bank.getCustomers());
        Predicate<Customer> hasTestBank = customer -> customer.getBanks().contains(bank);
        assertTrue(bank.getCustomers().stream().allMatch(hasTestBank));
    }

    @Test
    void test_setBank_branches() {
    }

    @Test
    void test_addCustomer() {
        for (Customer c : customerSet) {
            bank.addCustomer(c);
        }

        assertTrue(customerSet.stream()
                .allMatch(customer -> customer.getBanks().contains(bank)));

        bank.getCustomers().iterator()
                .forEachRemaining(customer -> assertTrue(customer.getBanks().contains(bank)));
    }

    @Test
    void test_removeCustomer() {
    }

    @Test
    void test_addBranch() {
        bank.addBranch(branch);

        assertTrue(bank.getBranches().contains(branch));
        assertEquals(bank, branch.getBank());
    }

    @Test
    void test_removeBranch() {
        bank.addBranch(branch);

        bank.removeBranch(branch);

        assertFalse(bank.getBranches().contains(branch));
    }
}