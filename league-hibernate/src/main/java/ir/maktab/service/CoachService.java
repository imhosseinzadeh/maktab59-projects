package ir.maktab.service;

import ir.maktab.dao.CoachDao;
import ir.maktab.entity.Coach;

public class CoachService extends AbstractCrudService<Coach, Long> {

    public CoachService() {
        super(new CoachDao());
    }

    @Override
    public CoachDao getBaseDao() {
        return (CoachDao) super.getBaseDao();
    }

    @Override
    public void delete(Coach coach) {
        getBaseDao().getTransaction().begin();
        Coach loadCoach = find(coach.getId());

        getBaseDao().delete(loadCoach);
        getBaseDao().getTransaction().commit();
    }
}
