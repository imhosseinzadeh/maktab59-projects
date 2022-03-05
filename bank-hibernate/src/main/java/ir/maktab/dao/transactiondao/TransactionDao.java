package ir.maktab.dao.transactiondao;

import ir.maktab.dao.BaseDao;
import ir.maktab.entity.customer.Account;
import ir.maktab.entity.transaction.Transaction;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

public class TransactionDao extends BaseDao<Transaction, Long> {

    @Override
    protected Class<Transaction> getEntityClass() {
        return Transaction.class;
    }

    public List<Transaction> loadByAccAndDate(Account account, LocalDate localDate) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Transaction> criteriaQuery = builder.createQuery(Transaction.class);
        Root<Transaction> transactionRoot = criteriaQuery.from(Transaction.class);

        criteriaQuery.select(transactionRoot);
        criteriaQuery.where(builder.equal(transactionRoot.get("tra_source_acc"), account));
        criteriaQuery.where(builder.greaterThan(transactionRoot.get("tra_date"), localDate));

        TypedQuery<Transaction> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
