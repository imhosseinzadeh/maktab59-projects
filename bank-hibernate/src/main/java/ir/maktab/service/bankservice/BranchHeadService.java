package ir.maktab.service.bankservice;

import ir.maktab.dao.bankdao.BranchHeadDao;
import ir.maktab.entity.bank.BranchHead;
import ir.maktab.service.AbstractCrudService;

public class BranchHeadService extends AbstractCrudService<BranchHead, Long> {

    public BranchHeadService() {
        setBaseDao(new BranchHeadDao());
    }

    @Override
    public BranchHeadDao getBaseDao() {
        return (BranchHeadDao) super.getBaseDao();
    }
}
