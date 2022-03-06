package ir.maktab.service.customerservice;

import ir.maktab.dao.customerdao.AccountDao;
import ir.maktab.entity.customer.Account;
import ir.maktab.service.AbstractCrudService;

public class AccountService extends AbstractCrudService<Account, String> {

    public AccountService() {
        setBaseDao(new AccountDao());
    }

    @Override
    public AccountDao getBaseDao() {
        return (AccountDao) super.getBaseDao();
    }

}
