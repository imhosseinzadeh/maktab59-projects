package ir.maktab.dao;

import ir.maktab.entity.Season;

public class SeasonDao extends BaseDao<Season, Long> {
    @Override
    protected Class<Season> getEntityClass() {
        return Season.class;
    }
}
