package ir.maktab.dao;

import ir.maktab.entity.Stadium;

public class StadiumDao extends BaseDao<Stadium, Long> {

    @Override
    protected Class<Stadium> getEntityClass() {
        return Stadium.class;
    }
}
