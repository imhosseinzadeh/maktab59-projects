package ir.maktab.dao.customerdao;

import ir.maktab.dao.BaseDao;
import ir.maktab.entity.customer.CreditCard;

public class CreditCardDao extends BaseDao<CreditCard, String> {

    @Override
    protected Class<CreditCard> getEntityClass() {
        return CreditCard.class;
    }
}
