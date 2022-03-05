package ir.maktab.dao;

import ir.maktab.entity.City;

public class CityDao extends BaseDao<City, Long> {

    @Override
    protected Class<City> getEntityClass() {
        return City.class;
    }
}
