package ir.maktab.service;

import ir.maktab.dao.ClubDao;
import ir.maktab.entity.Club;

public class ClubService extends AbstractCrudService<Club, Long> {

    public ClubService() {
        super(new ClubDao());
    }

    @Override
    public ClubDao getBaseDao() {
        return (ClubDao) super.getBaseDao();
    }
}
