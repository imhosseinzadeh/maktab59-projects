package ir.maktab.service;

import ir.maktab.dao.StadiumDao;
import ir.maktab.entity.Stadium;

public class StadiumService extends AbstractCrudService<Stadium, Long> {

    public StadiumService() {
        super(new StadiumDao());
    }

    @Override
    public StadiumDao getBaseDao() {
        return (StadiumDao) super.getBaseDao();
    }
}
