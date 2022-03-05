package ir.maktab.service.customerservice;

import ir.maktab.dao.customerdao.CustomerDao;
import ir.maktab.entity.customer.Customer;
import ir.maktab.service.AbstractCrudService;

public class CustomerService extends AbstractCrudService<Customer, Long> {

    public CustomerService() {
        setBaseDao(new CustomerDao());
    }

    @Override
    public CustomerDao getBaseDao() {
        return (CustomerDao) super.getBaseDao();
    }
}
