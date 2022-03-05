package ir.maktab.service;

import ir.maktab.dao.ClubCoachDao;
import ir.maktab.entity.ClubCoach;
import ir.maktab.entity.ClubCoachId;

public class ClubCoachService extends AbstractCrudService<ClubCoach, ClubCoachId> {

    public ClubCoachService() {
        super(new ClubCoachDao());
    }

    @Override
    public ClubCoachDao getBaseDao() {
        return (ClubCoachDao) super.getBaseDao();
    }
}
