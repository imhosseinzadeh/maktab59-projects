package ir.maktab.dao;


import ir.maktab.entity.Club;

public class ClubDao extends BaseDao<Club, Long> {

    @Override
    protected Class<Club> getEntityClass() {
        return Club.class;
    }
}
