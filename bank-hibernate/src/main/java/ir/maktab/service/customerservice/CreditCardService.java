package ir.maktab.service.customerservice;

import ir.maktab.dao.customerdao.CreditCardDao;
import ir.maktab.entity.customer.CreditCard;
import ir.maktab.service.AbstractCrudService;


public class CreditCardService extends AbstractCrudService<CreditCard, String> {

    public CreditCardService() {
        setBaseDao(new CreditCardDao());
    }

    @Override
    public CreditCardDao getBaseDao() {
        return (CreditCardDao) super.getBaseDao();
    }
}