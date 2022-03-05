package ir.maktab.dao.bankdao;

import ir.maktab.dao.BaseDao;
import ir.maktab.entity.bank.BranchHead;

public class BranchHeadDao extends BaseDao<BranchHead, Long> {

    @Override
    protected Class<BranchHead> getEntityClass() {
        return BranchHead.class;
    }
}
