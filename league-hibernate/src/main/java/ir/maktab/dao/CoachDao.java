package ir.maktab.dao;

import ir.maktab.entity.Coach;

public class CoachDao extends BaseDao<Coach, Long> {

    @Override
    protected Class<Coach> getEntityClass() {
        return Coach.class;
    }
}
