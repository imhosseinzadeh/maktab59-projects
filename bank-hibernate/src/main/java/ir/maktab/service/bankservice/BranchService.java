package ir.maktab.service.bankservice;

import ir.maktab.dao.bankdao.BranchDao;
import ir.maktab.entity.bank.Branch;
import ir.maktab.service.AbstractCrudService;

public class BranchService extends AbstractCrudService<Branch, Long> {

    public BranchService() {
        setBaseDao(new BranchDao());
    }

    @Override
    public BranchDao getBaseDao() {
        return (BranchDao) super.getBaseDao();
    }
}