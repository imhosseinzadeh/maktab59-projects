package ir.maktab.entity.bank;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BranchTest {

    private static Branch branch;

    private static Bank bank;
    private static BranchHead branchHead;

    @BeforeAll
    static void setUp() {
        branch = new Branch();
        bank = new Bank();
        branchHead = new BranchHead();
    }

    @Test
    void test_getBranch_bank() {
    }

    @Test
    void test_setBranch_bank() {
        branch.setBank(bank);

        assertEquals(bank, branch.getBank());
        assertTrue(bank.getBranches().contains(branch));
    }

    @Test
    void test_setBranch_branchHead() {
        branch.setBranchHead(branchHead);

        assertEquals(branchHead, branch.getBranchHead());
        assertEquals(branch, branchHead.getBranch());
    }

    @Test
    void test_setBranch_employees() {
    }

    @Test
    void test_setBranch_accounts() {
    }

    @Test
    void test_addAccount() {
    }

    @Test
    void test_removeAccount() {
    }

    @Test
    void test_addEmployee() {
    }

    @Test
    void test_removeEmployee() {
    }
}