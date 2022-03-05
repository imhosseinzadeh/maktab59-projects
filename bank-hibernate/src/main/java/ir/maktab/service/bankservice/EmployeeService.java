package ir.maktab.service.bankservice;

import ir.maktab.dao.bankdao.EmployeeDao;
import ir.maktab.entity.bank.Employee;
import ir.maktab.service.AbstractCrudService;

public class EmployeeService extends AbstractCrudService<Employee, Long> {

    public EmployeeService() {
        setBaseDao(new EmployeeDao());
    }

    @Override
    public EmployeeDao getBaseDao() {
        return (EmployeeDao) super.getBaseDao();
    }
}
