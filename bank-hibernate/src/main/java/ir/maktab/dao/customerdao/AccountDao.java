package ir.maktab.dao.customerdao;

import ir.maktab.dao.BaseDao;
import ir.maktab.entity.customer.Account;

public class AccountDao extends BaseDao<Account, String> {

    @Override
    protected Class<Account> getEntityClass() {
        return Account.class;
    }
}
