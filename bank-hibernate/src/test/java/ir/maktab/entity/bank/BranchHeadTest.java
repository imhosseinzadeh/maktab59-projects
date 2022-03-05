package ir.maktab.entity.bank;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BranchHeadTest {

    private static BranchHead branchHead;

    private static Branch branch;


    @BeforeAll
    static void setUp() {
        branchHead = new BranchHead();

        branch = new Branch();
    }

    @Test
    void test_setBrh_national_id() {
        String nationalId = "1111";
        branchHead.setNationalId(nationalId);

        assertEquals(nationalId, branchHead.getNationalId());
    }

    @Test
    void test_setBrh_firstname() {
        String firstName = "firstname example";
        branchHead.setFirstname(firstName);

        assertEquals(firstName, branchHead.getFirstname());
    }

    @Test
    void test_setBrh_lastname() {
        String lastName = "lastname example";
        branchHead.setLastname(lastName);

        assertEquals(lastName, branchHead.getLastname());
    }

    @Test
    void test_setBrh_Branch() {
        branchHead.setBranch(branch);

        assertEquals(branch, branchHead.getBranch());
    }
}