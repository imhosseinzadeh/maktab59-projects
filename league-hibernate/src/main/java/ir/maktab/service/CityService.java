package ir.maktab.service;

import ir.maktab.dao.CityDao;
import ir.maktab.entity.City;

public class CityService extends AbstractCrudService<City, Long> {

    public CityService() {
        super(new CityDao());
    }

    @Override
    public CityDao getBaseDao() {
        return (CityDao) super.getBaseDao();
    }
}
