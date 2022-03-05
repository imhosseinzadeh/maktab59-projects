package ir.maktab.dao;

import ir.maktab.entity.ClubCoach;
import ir.maktab.entity.ClubCoachId;

public class ClubCoachDao extends BaseDao<ClubCoach, ClubCoachId> {
    @Override
    protected Class<ClubCoach> getEntityClass() {
        return ClubCoach.class;
    }
}
