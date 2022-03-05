package ir.maktab.dao.bankdao;

import ir.maktab.dao.BaseDao;
import ir.maktab.entity.bank.Branch;

public class BranchDao extends BaseDao<Branch, Long> {

    @Override
    protected Class<Branch> getEntityClass() {
        return Branch.class;
    }
}
