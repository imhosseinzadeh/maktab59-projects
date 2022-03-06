package ir.maktab.service.customerservice;

import ir.maktab.dao.customerdao.AccountDao;
import ir.maktab.entity.customer.Account;
import ir.maktab.service.AbstractCrudService;

import java.util.Optional;

public class AccountService extends AbstractCrudService<Account, String> {

    public AccountService() {
        setBaseDao(new AccountDao());
    }

    @Override
    public AccountDao getBaseDao() {
        return (AccountDao) super.getBaseDao();
    }

    @Override
    public Optional<Account> load(String s) {
        return super.load(s);
    }
}
