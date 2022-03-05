package ir.maktab.dao.customerdao;

import ir.maktab.dao.BaseDao;
import ir.maktab.entity.customer.Customer;

public class CustomerDao extends BaseDao<Customer, Long> {

    @Override
    protected Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
