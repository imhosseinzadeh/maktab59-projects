package ir.maktab.dao.bankdao;

import ir.maktab.dao.BaseDao;
import ir.maktab.entity.bank.Bank;

public class BankDao extends BaseDao<Bank, Long> {

    @Override
    protected Class<Bank> getEntityClass() {
        return Bank.class;
    }
}
