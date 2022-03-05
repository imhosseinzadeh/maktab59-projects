package ir.maktab.dao.bankdao;

import ir.maktab.dao.BaseDao;
import ir.maktab.entity.bank.Employee;

public class EmployeeDao extends BaseDao<Employee, Long> {

    @Override
    protected Class<Employee> getEntityClass() {
        return Employee.class;
    }
}
