package ir.maktab.service.bankservice;

import ir.maktab.dao.bankdao.BankDao;
import ir.maktab.entity.bank.Bank;
import ir.maktab.service.AbstractCrudService;

public class BankService extends AbstractCrudService<Bank, Long> {

    public BankService() {
        setBaseDao(new BankDao());
    }

    @Override
    public BankDao getBaseDao() {
        return (BankDao) super.getBaseDao();
    }
}
