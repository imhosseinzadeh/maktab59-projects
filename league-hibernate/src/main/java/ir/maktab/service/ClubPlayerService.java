package ir.maktab.service;

import ir.maktab.dao.ClubPlayerDao;
import ir.maktab.entity.ClubPlayer;
import ir.maktab.entity.ClubPlayerId;

public class ClubPlayerService extends AbstractCrudService<ClubPlayer, ClubPlayerId> {

    public ClubPlayerService() {
        super(new ClubPlayerDao());
    }

    @Override
    public ClubPlayerDao getBaseDao() {
        return (ClubPlayerDao) super.getBaseDao();
    }
}
