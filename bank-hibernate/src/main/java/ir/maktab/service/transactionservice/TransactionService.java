package ir.maktab.service.transactionservice;

import ir.maktab.dao.transactiondao.TransactionDao;
import ir.maktab.entity.customer.Account;
import ir.maktab.entity.transaction.Transaction;
import ir.maktab.service.AbstractCrudService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class TransactionService extends AbstractCrudService<Transaction, Long> {

    public TransactionService() {
        setBaseDao(new TransactionDao());
    }

    @Override
    public TransactionDao getBaseDao() {
        return (TransactionDao) super.getBaseDao();
    }

    public Optional<List<Transaction>> loadByAccAndDate(Account account, LocalDate localDate) {
        return Optional.ofNullable(getBaseDao().loadByAccAndDate(account, localDate));
    }
}
